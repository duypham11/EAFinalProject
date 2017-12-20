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

import com.fasterxml.jackson.core.type.TypeReference;

import cs544.mum.edu.domain.Rider;
import cs544.mum.edu.model.CommonResponseDTO;
import cs544.mum.edu.model.RiderDTO;
import cs544.mum.edu.model.StoreDTO;
import cs544.mum.edu.service.ParcelService;
import cs544.mum.edu.service.RiderService;
import cs544.mum.edu.service.StoreService;
import cs544.mum.edu.service.UsernameService;
import cs544.mum.edu.util.CALConnector;
import cs544.mum.edu.util.JsonUtils;

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
		String calAPI = "http://localhost:8080/FlashDelivery/";
		List<RiderDTO> listOfRiderDTOs = null;
		String finalOutput = CALConnector.callRest(calAPI+"rest/fetchrider",RequestMethod.GET,null, null);
		CommonResponseDTO commonResponseDTO = JsonUtils.getObjectFromJson(finalOutput,CommonResponseDTO.class);
		String commonResp = JsonUtils.getJsonFromObject(commonResponseDTO.getResponseObject());
		if(commonResponseDTO.getResponseCode()==1.0) {
			listOfRiderDTOs = JsonUtils.getObjectFromJson(commonResp, new TypeReference<List<RiderDTO>>(){});
		}
		model.addAttribute("listOfriders",listOfRiderDTOs);
		return "riders";
	}
	@RequestMapping(value = {"/approvestore/{userName:.+}"}, method = RequestMethod.GET)
	public String approveStore(@PathVariable String userName) {	
		String calAPI = "http://localhost:8080/FlashDelivery/";
		String inputData = JsonUtils.getJsonFromObject(userName);
		String finalOutput = CALConnector.callRest(calAPI+"rest/approve/"+userName,RequestMethod.GET,null, null);
		CommonResponseDTO commonResponseDTO = JsonUtils.getObjectFromJson(finalOutput,CommonResponseDTO.class);
		/*userService.enableUser(userName);*/
		return "forward:/fetchstore";
	}
	@RequestMapping(value = {"/approverider/{userName:.+}"}, method = RequestMethod.GET)
	public String approveRider(@PathVariable String userName) {		
		String calAPI = "http://localhost:8080/FlashDelivery/";
		String inputData = JsonUtils.getJsonFromObject(userName);
		String finalOutput = CALConnector.callRest(calAPI+"rest/approve/"+userName,RequestMethod.GET,null, null);
		CommonResponseDTO commonResponseDTO = JsonUtils.getObjectFromJson(finalOutput,CommonResponseDTO.class);
		/*userService.enableUser(userName);*/
		return "forward:/fetchrider";
	}
	
	@RequestMapping(value = {"/fetchstore"}, method = RequestMethod.GET)
	public String fetchStore(Locale locale, Model model) {	
		String calAPI = "http://localhost:8080/FlashDelivery/";
		List<StoreDTO> listOfStoreDTOs = null;
		String finalOutput = CALConnector.callRest(calAPI+"rest/fetchstore",RequestMethod.GET,null, null);
		CommonResponseDTO commonResponseDTO = JsonUtils.getObjectFromJson(finalOutput,CommonResponseDTO.class);
		String commonResp = JsonUtils.getJsonFromObject(commonResponseDTO.getResponseObject());
		if(commonResponseDTO.getResponseCode()==1.0) {
		listOfStoreDTOs = JsonUtils.getObjectFromJson(commonResp, new TypeReference<List<StoreDTO>>(){});
		}
		model.addAttribute("listOfstores",listOfStoreDTOs);
		return "stores";
	}

}
