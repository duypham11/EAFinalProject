package cs544.mum.edu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.mum.edu.domain.Rider;
import cs544.mum.edu.domain.Store;
import cs544.mum.edu.model.RiderDTO;
import cs544.mum.edu.model.StoreDTO;
import cs544.mum.edu.service.ParcelService;
import cs544.mum.edu.service.RiderService;
import cs544.mum.edu.service.StoreService;
import cs544.mum.edu.service.UsernameService;

@Controller
public class AdminController {
	
	
	@Autowired
	StoreService storeService;
	
	@Autowired
	UsernameService userService;
	
	@Autowired
	ParcelService parcelService;
	
	@Autowired
	RiderService riderService;
	
	
	@RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	
		return "admin";
	}
	@RequestMapping(value = {"/fetchrider"}, method = RequestMethod.GET)
	public String fetchRider(Locale locale, Model model) {	
		List<Rider> listOfRiders = riderService.findAll();
		List<RiderDTO> listOfRiderDTOs = new ArrayList<RiderDTO>();
		for(Rider rider : listOfRiders) {
			RiderDTO riderDTO = new RiderDTO();
			riderDTO.setRiderName(rider.getFirstName());
			riderDTO.setUserName(rider.getUserCredentials().getUsername());
			riderDTO.setAddress(rider.getAddress() != null?rider.getAddress().getAddress():null);
			riderDTO.setEmail(rider.getEmail());
			riderDTO.setPhone(rider.getAddress() != null?rider.getAddress().getPhone():null);
			riderDTO.setState(rider.getAddress() != null?rider.getAddress().getState():null);
			riderDTO.setStatus(rider.getUserCredentials().getEnabled().toString());
			listOfRiderDTOs.add(riderDTO);
		}
		model.addAttribute("listOfriders",listOfRiderDTOs);
		return "riders";
	}
	@RequestMapping(value = {"/approvestore/{userName:.+}"}, method = RequestMethod.GET)
	public String approveStore(@PathVariable String userName) {	
		userService.enableUser(userName);
		return "forward:/fetchstore";
	}
	@RequestMapping(value = {"/approverider/{userName:.+}"}, method = RequestMethod.GET)
	public String approveRider(@PathVariable String userName) {	
		userService.enableUser(userName);
		return "forward:/fetchrider";
	}
	
	@RequestMapping(value = {"/fetchstore"}, method = RequestMethod.GET)
	public String fetchStore(Locale locale, Model model) {	
		List<Store> listOfStores = storeService.findAll();
		List<StoreDTO> listOfStoreDTOs = new ArrayList<StoreDTO>();
		for(Store store : listOfStores) {
			StoreDTO storeDTO = new StoreDTO();
			storeDTO.setStoreName(store.getName());
			storeDTO.setAddress(store.getAddress() != null?store.getAddress().getAddress():null);
			storeDTO.setState(store.getAddress() != null?store.getAddress().getState():null);
			storeDTO.setEmail(store.getEmail());
			storeDTO.setUserName(store.getUserCredentials().getUsername());
			storeDTO.setZipcode(store.getAddress() != null?store.getAddress().getZipCode():null);
			storeDTO.setStatus(store.getUserCredentials().getEnabled().toString());
			listOfStoreDTOs.add(storeDTO);
		}
		model.addAttribute("listOfstores",listOfStoreDTOs);
		return "stores";
	}

}
