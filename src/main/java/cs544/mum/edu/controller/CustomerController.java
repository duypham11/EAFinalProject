package cs544.mum.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.model.TrackParcelDTO;
import cs544.mum.edu.service.ParcelService;
import cs544.mum.edu.service.UsernameService;
@Controller
public class CustomerController {

	
	@Autowired
	UsernameService userService;
	
	@Autowired
	ParcelService parcelService;
	
	@RequestMapping(value = "/trackParcel", method = RequestMethod.GET)
	public String approveRider(@RequestParam("tracknumber") String tracknumber,Model model) {	
		Parcel parcel = parcelService.findByTrackNumber(tracknumber);
		TrackParcelDTO trackParcelDTO =null;
		if(parcel != null)
		trackParcelDTO = new TrackParcelDTO(parcel.getTrackNumber(),parcel.getCustomerName(),parcel.getAddressAsString(),parcel.getStatus().getStatus());
		model.addAttribute("trackedParcel",trackParcelDTO);
		return "trackorder";
	}
}
