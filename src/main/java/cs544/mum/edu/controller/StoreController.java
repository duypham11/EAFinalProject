package cs544.mum.edu.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cs544.mum.edu.domain.Store;
import cs544.mum.edu.service.ParcelService;
import cs544.mum.edu.service.StoreService;
import cs544.mum.edu.domain.Parcel;

@Controller
public class StoreController {
	@Autowired
	StoreService storeService;
	
	@Autowired
	ParcelService parcelService;
	
	@RequestMapping(value = {"/store"}, method = RequestMethod.GET)
	public String store(Model model) {	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Store store = storeService.findByUsername(username);
        List<Parcel> list = parcelService.getParcelsByStoreId(store.getId());
        model.addAttribute("parcels", list );
		return "store";
	}
	
	@RequestMapping(value = {"/storeRequestRider"}, method = RequestMethod.GET)
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
}
