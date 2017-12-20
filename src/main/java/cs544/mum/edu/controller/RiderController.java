package cs544.mum.edu.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
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
import org.springframework.web.servlet.ModelAndView;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.ParcelStatus;
import cs544.mum.edu.domain.Rider;
import cs544.mum.edu.domain.Role;
import cs544.mum.edu.domain.Store;
import cs544.mum.edu.exception.ParcelNotFoundException;
import cs544.mum.edu.service.EmailService;
import cs544.mum.edu.service.ParcelService;
import cs544.mum.edu.service.ParcelStatusService;
import cs544.mum.edu.service.RiderService;
import cs544.mum.edu.service.RoleService;
import cs544.mum.edu.service.StoreService;
import cs544.mum.edu.validator.PasswordValidator;


@Controller
//@RequestMapping(value="/rider")
public class RiderController {

	@Autowired
	private RiderService riderService;	
	
	@Autowired
	PasswordValidator passwordValidator;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	ParcelService parcelService;
	
	@Autowired
	ParcelStatusService parcelStatusService;
	
	@RequestMapping(value="/rider/{id}", method = RequestMethod.GET)
	public ModelAndView homePage(@PathVariable("id") long id) {		
		ModelAndView model = new ModelAndView("/rider/pacerl_list");
		List<Parcel> pacerlList = riderService.getRider(id).getParcelList();
		model.addObject("pacerl_list", pacerlList);		
		return model;
	}
	
	@RequestMapping(value="/rider/riderSignup", method = RequestMethod.GET)
	public String signup(@ModelAttribute("newRider") Rider rider) {
		return "/rider/riderSignup";
	}
	@RequestMapping(value = "/rider/processRider", method = RequestMethod.POST)
	public String processRiderSignupForm(@Valid @ModelAttribute("newRider") Rider rider,
			BindingResult bindingResult) {

		passwordValidator.validate(rider, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/rider/riderSignup";
		}
		
		String userUID = UUID.randomUUID().toString();
		
		Role role = new Role();
		role.setUsername(rider.getEmail());
		role.setRole("ROLE_RIDER");
		
		rider.getUserCredentials().addRole(role);
		rider.getUserCredentials().setUsername(rider.getEmail());
		rider.getUserCredentials().setUID(userUID);
		rider.getUserCredentials().setEnabled(true);
		riderService.createRider(rider);
		rider.setFirstName("nhungjhgn");
		riderService.saveRider(rider);
		return "redirect:/rider/riderSuccess";
	}
	@RequestMapping(value = "/rider/riderSuccess")
	public String successRiderSignup() {
		return "/rider/riderSuccess";
	}
	
	@RequestMapping(value="/riderProfile", method = RequestMethod.GET, produces = "application/json")
	//@PreAuthorize("hasRole('ROLE_RIDER')")
	public @ResponseBody String getProfile() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        Rider rider = riderService.findRiderByUserName(username); 
        Rider rRider = new Rider();
        
        rRider.setRider_Id(rider.getRider_Id());
        rRider.setFirstName(rider.getFirstName());
        rRider.setLastName(rider.getLastName());
        rRider.setAddress(rider.getAddress());
        rRider.setEmail(rider.getEmail());
        rRider.setRate(rider.getRateObj());
        System.out.println(rRider);

 		return rRider.toString();
	}
	
	// Rider home
	@RequestMapping(value = "/rider/riderHome")
	public String getRiderHome(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Rider rider = riderService.findRiderByUserName(username);
        model.addAttribute("RiderName", rider.getFirstName() + " " + rider.getLastName());
        model.addAttribute("RiderID", rider.getRider_Id());
        
		List<Parcel> parcelList = rider.getNotDoneParcelList();
		model.addAttribute("notDoneParcelList", parcelList);
		
		List<Parcel> completedParcelList = rider.getDoneParcelList();
		model.addAttribute("completedParcelList", completedParcelList);
		
		List<Parcel> allParcelAvailable = parcelService.findParcelByParcelStatus("NEW");
		model.addAttribute("allParcelAvailable", allParcelAvailable);
		
		return "rider/riderHome";
	}
	@RequestMapping(value = "/completeParcel/{parcelId}/{parcelTrackNumber}", method = RequestMethod.POST)
	public @ResponseBody String completedParcel(
			@PathVariable(value = "parcelId") Long parcelId,
			@PathVariable(value = "parcelTrackNumber") String parcelTrackNumber
	) {
		Parcel parcel = parcelService.find(parcelId);
		
		if (!parcelTrackNumber.equalsIgnoreCase(parcel.getTrackNumber())) {
			throw new ParcelNotFoundException("Parcel not found");
		}

		ParcelStatus ps = parcelStatusService.findByStatus("DONE");
		parcel.setStatus(ps);

		parcelService.save(parcel);
		return "{\"sucess\":\"true\"}";
	}
	
	@RequestMapping(value = "/selectParcel/{riderId}/{parcelId}", method = RequestMethod.POST)
	public @ResponseBody String selectedParcel(
			@PathVariable(value = "riderId") Long riderId,
			@PathVariable(value = "parcelId") Long parcelId) {
		
		Parcel parcel = parcelService.find(parcelId);
		
		ParcelStatus ps = parcelStatusService.findByStatus("RIDING");
		
		parcel.setRider(riderService.getRider(riderId));
		parcel.setStatus(ps);
		parcelService.save(parcel);
		return "{\"sucess\":\"true\"}";
	}
	
	
}