package cs544.mum.edu.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.ParcelHistory;
import cs544.mum.edu.model.CommonResponseDTO;
import cs544.mum.edu.model.TrackParcelDTO;
import cs544.mum.edu.service.ParcelHistoryService;
import cs544.mum.edu.service.ParcelService;
import cs544.mum.edu.service.UsernameService;
@RestController
@RequestMapping(value = "/customer_rest")
public class CustomerRest {

	
	@Autowired
	UsernameService userService;
	
	@Autowired
	ParcelService parcelService;
	
	@Autowired
	ParcelHistoryService parcelHistoryService;
	
	@RequestMapping(value = "/trackParcel", method = RequestMethod.GET)
	public CommonResponseDTO approveRider(@RequestParam("tracknumber") String tracknumber,Model model) {
		CommonResponseDTO commonResponse = new CommonResponseDTO();
		try {
		Parcel parcel = parcelService.findByTrackNumber(tracknumber);
		TrackParcelDTO trackParcelDTO =null;
		if(parcel != null)
		trackParcelDTO = new TrackParcelDTO(parcel.getTrackNumber(),parcel.getCustomerName(),parcel.getAddressAsString(),parcel.getStatus().getStatus());
		List<ParcelHistory> listOfParcelHistory = parcelHistoryService.parcelHistoryByTrackNumber(tracknumber);
		List<String> listOfParcelLog = new ArrayList<String>();
		for(ParcelHistory parcelHistory: listOfParcelHistory) {
			String log = parcelHistory.getTrackingNO()+" has been changed from "+parcelHistory.getPreviousState()+" to "+parcelHistory.getCurrentState()+" by "+parcelHistory.getModifiedBy()+" on"+parcelHistory.getTimestamp();
			listOfParcelLog.add(log);
		}
		
		trackParcelDTO.setHistoryLog(listOfParcelLog);
		commonResponse.setResponseCode(1);
		commonResponse.setResponseMessage("success");
		commonResponse.setResponseObject(trackParcelDTO);
		}
		catch(Exception e) {
			commonResponse.setResponseCode(-1);
			commonResponse.setResponseMessage(e.getMessage());
			e.printStackTrace();
		}
		return commonResponse;
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
