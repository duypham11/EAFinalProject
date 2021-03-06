package cs544.mum.edu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.ParcelHistory;
import cs544.mum.edu.model.CommonResponseDTO;
import cs544.mum.edu.model.StoreDTO;
import cs544.mum.edu.model.TrackParcelDTO;
import cs544.mum.edu.service.ParcelHistoryService;
import cs544.mum.edu.service.ParcelService;
import cs544.mum.edu.service.UsernameService;
import cs544.mum.edu.util.CALConnector;
import cs544.mum.edu.util.JsonUtils;
@Controller
public class CustomerController {

	
	@Autowired
	UsernameService userService;
	
	@Autowired
	ParcelService parcelService;
	
	@Autowired
	ParcelHistoryService parcelHistoryService;
	
	@RequestMapping(value = "/trackParcel", method = RequestMethod.GET)
	public String approveRider(@RequestParam("tracknumber") String tracknumber,Model model) {	
		String calAPI = "http://localhost:8080/FlashDelivery/";
		String inputData = JsonUtils.getJsonFromObject(tracknumber);
		String finalOutput = CALConnector.callRest(calAPI+"customer_rest/trackParcel?tracknumber="+tracknumber,RequestMethod.GET,null, null);
		CommonResponseDTO commonResponseDTO = JsonUtils.getObjectFromJson(finalOutput,CommonResponseDTO.class);
		String commonResp = JsonUtils.getJsonFromObject(commonResponseDTO.getResponseObject());
		TrackParcelDTO trackParcelDTO =null;
		if(commonResponseDTO.getResponseCode()==1.0) {
//		commonResp	= "{"trackingNumber":"123456","customerName":"Josh Stark 3","delieveryAddress":"304 W.Hempstead Avenue Fairfield, IA, null, null","delieveryStatus":"NEW","historyLog":[]}";
//			trackParcelDTO = JsonUtils.getObjectFromJson(commonResp, TrackParcelDTO.class);
			trackParcelDTO = JsonUtils.getObjectFromJson(commonResp, TrackParcelDTO.class);
			}
/*		Parcel parcel = parcelService.findByTrackNumber(tracknumber);
		if(parcel != null)
		trackParcelDTO = new TrackParcelDTO(parcel.getTrackNumber(),parcel.getCustomerName(),parcel.getAddressAsString(),parcel.getStatus().getStatus());
		List<ParcelHistory> listOfParcelHistory = parcelHistoryService.parcelHistoryByTrackNumber(tracknumber);
		List<String> listOfParcelLog = new ArrayList<String>();
		for(ParcelHistory parcelHistory: listOfParcelHistory) {
			String log = parcelHistory.getTrackingNO()+" has been changed from "+parcelHistory.getPreviousState()+" to "+parcelHistory.getCurrentState()+" by "+parcelHistory.getModifiedBy()+" on"+parcelHistory.getTimestamp();
			listOfParcelLog.add(log);
		}
		
		trackParcelDTO.setHistoryLog(listOfParcelLog);*/
		model.addAttribute("trackedParcel",trackParcelDTO);
		return "trackorder";
	}
	
	@RequestMapping(value = "/mockHistory", method = RequestMethod.GET)
	public String mockHistory() {	
		ParcelHistory ph = new ParcelHistory();
		ph.setModifiedBy("Nirav");
		ph.setPreviousState("new");
		ph.setTrackingNO("234565");
		ph.setCurrentState("Dispatched");
		parcelHistoryService.save(ph);
		return null;
	}
}
