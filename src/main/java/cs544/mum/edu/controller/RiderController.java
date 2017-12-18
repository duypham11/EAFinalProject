package cs544.mum.edu.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.Rider;
import cs544.mum.edu.domain.Role;
import cs544.mum.edu.service.ParcelService;
import cs544.mum.edu.service.RiderService;
import cs544.mum.edu.service.RoleService;
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
	
	@RequestMapping(value="/rider/{id}", method = RequestMethod.GET)
	public ModelAndView homePage(@PathVariable("id") long id) {		
		ModelAndView model = new ModelAndView("/rider/pacerl_list");
		List<Parcel> pacerlList = riderService.getRider(id).getParcelList();
		System.out.println("======list=Parcel==" + pacerlList.size());
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
		
		//MultipartFile employeePhoto = rider.getPhoto();
//		String rootDirectory = servletContext.getRealPath("/");
		String userUID = UUID.randomUUID().toString();
		
//		if (employeePhoto != null && !employeePhoto.isEmpty()) {
//			try {
//				
//				String photoURL = rootDirectory + "resources/images/" + userUID + ".png";
//				employeePhoto.transferTo(new File(photoURL));
//				rider.setPhotoURL(userUID);
//				
//			} catch (Exception e) {
//				throw new RuntimeException("Employee photo saving failed", e);
//				//throw new UnableToUploadPhotoException("Employee photo saving failed");
//			}
//		}
		
		Role role = new Role();
		role.setUsername(rider.getEmail());
		role.setRole("ROLE_RIDER");
		
		System.out.println("======/rider/processRider====="+rider.getEmail()+"=========" + userUID);

		rider.getUserCredentials().addRole(role);
		rider.getUserCredentials().setUsername(rider.getEmail());
		rider.getUserCredentials().setUID(userUID);
		rider.getUserCredentials().setEnabled(true);
		riderService.createRider(rider);
		
		return "redirect:/rider/riderSuccess";
	}
	@RequestMapping(value = "/rider/riderSuccess")
	public String successRiderSignup() {
		return "/rider/riderSuccess";
	}
	
	// Rider home
	@RequestMapping(value = "/rider/riderHome")
	public String getRiderHome(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Rider rider = riderService.findRiderByUserName(username);
        
        
		List<Parcel> parcelList = rider.getNotDoneParcelList();
		model.addAttribute("notDoneParcelList", parcelList);
		
		List<Parcel> completedParcelList = rider.getDoneParcelList();
		model.addAttribute("completedParcelList", completedParcelList);
		
		List<Parcel> allParcelAvailable = parcelService.findParcelByParcelStatus("NEW");
		model.addAttribute("allParcelAvailable", allParcelAvailable);
		
		return "rider/riderHome";
	}
}