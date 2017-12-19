package cs544.mum.edu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cs544.mum.edu.domain.Store;
import cs544.mum.edu.service.ParcelService;
import cs544.mum.edu.service.ParcelStatusService;
import cs544.mum.edu.service.StoreService;
import cs544.mum.edu.domain.Address;
import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.ParcelStatus;
import cs544.mum.edu.domain.Result;
import cs544.mum.edu.domain.Role;

@Controller
public class StoreController {
	@Autowired
	StoreService storeService;
	
	@Autowired
	ParcelService parcelService;
	
	@RequestMapping(value = {"/store"}, method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_STORE')")
	public String store(Model model) {	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Store store = storeService.findByUsername(username);
        List<Parcel> list = parcelService.getParcelsByStoreId(store.getId());
        model.addAttribute("parcels", list );
		return "store";
	}
	
	@RequestMapping(value = {"/storeRequestRider"}, method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_STORE')")
	public String storeOrderDelivery(Locale locale, Model model) {	
		return "storeRequestRider";
	}
	
	@RequestMapping(value="/storeProfile", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_STORE')")
	public @ResponseBody Store getProfile() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        Store store = new Store();
        try {
        		Store res = storeService.findByUsername(username);
        		
        		store.setId(res.getId());
        		store.setName(res.getName());
        		store.setFirstName(res.getFirstName());
        		store.setLastName(res.getLastName());
        		store.setAddress(res.getAddress());
        		store.setEmail(res.getEmail());
        		store.setNote(res.getNote());
        }catch (Exception e){
        		System.out.println("Error: " +e);
        }
        
        System.out.println(store);
        
 		return store;
	}
	
	@RequestMapping(value="/storeSignup", method = RequestMethod.GET)
	public String signupStore(@ModelAttribute("store") Store store) {
 		return "storeSignup";
	}
	
	@RequestMapping(value="/storeSignup", method = RequestMethod.POST)
	public String signupStore(@Valid @ModelAttribute("store") Store store, 
			BindingResult bindingResult) {
		System.out.println("load page storeSignup ");
		
		if(bindingResult.hasErrors()) {
			return "storeSignup";
		}
		
		//use email as user name
		store.getUserCredentials().setUsername(store.getEmail());
		
		//create role
		Role role = new Role();
		role.setUsername(store.getEmail());
		role.setRole("ROLE_STORE");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		
		//append role
		store.getUserCredentials().setRole(roles);
		store.getUserCredentials().setEnabled(false);
		store.getUserCredentials().setUID(UUID.randomUUID().toString());
		
		//save store and user credential
		storeService.saveFull(store);
 		
		return "redirect:/storeSignupThank";
	}
	
	@RequestMapping(value="/storeSignupThank", method = RequestMethod.GET)
	public String signupThank(Model model) {
 		return "storeSignupThank";
	}
	
	@RequestMapping(value="/cancelRiderRequest/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_STORE')")
	public @ResponseBody Result cancelRiderRequest(@PathVariable("id") Long id) {
		Result result = new Result();
		
		Parcel parcel = parcelService.find(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(parcel.getStore().getEmail().equals(auth.getName())) {
			try {
				ParcelStatus status = new ParcelStatus();
				status.setId(new Long(4));
				parcel.setStatus(status);
				parcelService.save(parcel);
				
				result.setStatus(Result.Status.SUCCESS);
				result.setMessage("Request for rider has been cancelled successfully!");
			}catch(Exception e) {
				result.setMessage(e.getMessage());
			}
		}
		
		return result;
	}
}
