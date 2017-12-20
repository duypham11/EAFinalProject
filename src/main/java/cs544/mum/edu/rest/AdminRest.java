package cs544.mum.edu.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs544.mum.edu.domain.Rider;
import cs544.mum.edu.domain.Store;
import cs544.mum.edu.model.CommonResponseDTO;
import cs544.mum.edu.model.RiderDTO;
import cs544.mum.edu.model.StoreDTO;
import cs544.mum.edu.service.ParcelService;
import cs544.mum.edu.service.RiderService;
import cs544.mum.edu.service.StoreService;
import cs544.mum.edu.service.UsernameService;

@RestController
@RequestMapping(value = "/rest")
public class AdminRest {
	
	
	@Autowired
	StoreService storeService;
	
	@Autowired
	UsernameService userService;
	
	@Autowired
	ParcelService parcelService;
	
	@Autowired
	RiderService riderService;
	
	
	
	@RequestMapping(value = {"/fetchrider"}, method = RequestMethod.GET)
	public CommonResponseDTO fetchRider() {	
		CommonResponseDTO commonResponse = new CommonResponseDTO();
		try {
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
		
		commonResponse.setResponseCode(1);
		commonResponse.setResponseMessage("success");
		commonResponse.setResponseObject(listOfRiderDTOs);
		}
		catch(Exception e) {
			commonResponse.setResponseCode(-1);
			commonResponse.setResponseMessage(e.getMessage());
			e.printStackTrace();
		}
		return commonResponse;
	}

	@RequestMapping(value = {"/approve/{userName:.+}"}, method = RequestMethod.GET)
	public CommonResponseDTO approve(@PathVariable String userName) {	
		CommonResponseDTO commonResponse = new CommonResponseDTO();
		try {
		userService.enableUser(userName);
		commonResponse.setResponseCode(1);
		commonResponse.setResponseMessage("success");
		}
		catch(Exception e) {
			e.printStackTrace();
			commonResponse.setResponseCode(-1);
			commonResponse.setResponseMessage(e.getMessage());
		}
		return commonResponse;
	}
	
	@RequestMapping(value = {"/fetchstore"}, method = RequestMethod.GET)
	public CommonResponseDTO fetchStore() {	
		CommonResponseDTO commonResponse = new CommonResponseDTO();
		try {
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
		commonResponse.setResponseCode(1);
		commonResponse.setResponseMessage("success");
		commonResponse.setResponseObject(listOfStoreDTOs);
		}
		catch(Exception e) {
			commonResponse.setResponseCode(-1);
			commonResponse.setResponseMessage(e.getMessage());
			e.printStackTrace();
		}
		return commonResponse;
	
	}

}
