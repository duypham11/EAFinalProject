package cs544.mum.edu.webflow;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.ParcelStatus;
import cs544.mum.edu.domain.Rider;
import cs544.mum.edu.domain.Store;
import cs544.mum.edu.service.EmailService;
import cs544.mum.edu.service.ParcelService;
import cs544.mum.edu.service.RiderService;
import cs544.mum.edu.service.StoreService;

@Component
public class requestRiderControllerHelper {

	@Autowired
	ParcelService parcelService;
	
	@Autowired
	RiderService riderService;
	
	@Autowired
	StoreService storeService;
	
	@Autowired
	EmailService emailService;
	
	public Parcel saveParcel(Parcel parcel, Rider rider) {
		ParcelStatus parcelStatus = new ParcelStatus();
		parcelStatus.setId(new Long(1));
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
		Store res =	 storeService.findByUsername(username);
		
		parcel.setRider(rider);
		parcel.setStatus(parcelStatus);
		parcel.setStore(res);
		parcel.setTrackNumber(parcelService.getNextTrackNo());
		
		return parcelService.save(parcel);
	}
	
	public Parcel initiate() {
		System.out.println("webflow init");
		Parcel parcel = new Parcel();
		return parcel;
	}
	
	public Rider getAvailableRider(){
		List<Rider> list = riderService.getAvailableRider();

		return list.get(0);
	}
	
	public void sendOutNotifcation(Parcel parcel, Rider rider) {
		
		//one copy to customer 
		SimpleMailMessage emailToCust = new SimpleMailMessage();
		
		emailToCust.setTo(parcel.getEmail());
		emailToCust.setSubject("Order Complete " + parcel.getTrackNumber());
		emailToCust.setText("your tracking number is " + parcel.getTrackNumber());
		emailService.sendEmail(emailToCust);
		
		//one copy for rider
		SimpleMailMessage emailToRider = new SimpleMailMessage();
		System.out.println("rider email " + rider.getEmail());
		
		emailToRider.setTo(rider.getEmail());
		emailToRider.setSubject("Order Delivery Task " + parcel.getTrackNumber());
		emailToRider.setText("This task is for customer " + parcel.getCustomerName());
		emailService.sendEmail(emailToRider);
		
		//one copy for store owner
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
		Store res =	 storeService.findByUsername(username);
		
		SimpleMailMessage emailToStore = new SimpleMailMessage();
		System.out.println("store email " + res.getEmail());
		
		emailToStore.setTo(res.getEmail());
		emailToStore.setSubject("A rider request " + parcel.getTrackNumber());
		emailToStore.setText("A rider has been assigned to you, " + rider.getFirstName());
		emailService.sendEmail(emailToStore);
	}
	
}
