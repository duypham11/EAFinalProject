package cs544.mum.edu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.Store;
import cs544.mum.edu.service.EmailService;
import cs544.mum.edu.service.StoreService;

@Component
@Aspect
@EnableAspectJAutoProxy
public class RiderAdvice {
	@Autowired
	EmailService emailService;
	
	
	@Autowired
	StoreService storeService;
	
	@After("execution(public * cs544.mum.edu.service.ParcelService.save(..))")
	public void sendEmailNotify(JoinPoint jp) {
		Object[] args = jp.getArgs();
		Parcel parcel = (Parcel) args[0];
		if (parcel.getStatus() !=null && parcel.getStatus().getStatus().equals("DONE")) {
			sendOutDeliveredNotifcation(parcel);
			System.out.println("===========sendEmailNotify=================");
		}
	}
	
public void sendOutDeliveredNotifcation(Parcel parcel) {
	try {
		//one copy to customer 
		SimpleMailMessage emailToCust = new SimpleMailMessage();
		
		emailToCust.setTo(parcel.getEmail());
		emailToCust.setSubject("Your Parcel has been delivered, tracking number: " + parcel.getTrackNumber());
		emailToCust.setText("Your Parcel has been delivered, tracking number: " + parcel.getTrackNumber());
		emailService.sendEmail(emailToCust);
		
		//one copy for rider
		SimpleMailMessage emailToRider = new SimpleMailMessage();
		
		emailToRider.setTo(parcel.getRider().getEmail());
		emailToRider.setSubject("Deliver successfully: " + parcel.getTrackNumber());
		emailToRider.setText("Your task is for customer " + parcel.getCustomerName() + " done. Thank you!");
		emailService.sendEmail(emailToRider);
		
		//one copy for store owner
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
		Store res =	 storeService.findByUsername(username);
		
		SimpleMailMessage emailToStore = new SimpleMailMessage();
		System.out.println("store email " + res.getEmail());
		
		emailToStore.setTo(res.getEmail());
		emailToStore.setSubject("A rider has delivered the parcel: " + parcel.getTrackNumber());
		emailToStore.setText("The rider has delivered the parcel to " + parcel.getRider().getFirstName() + " with tracking number: " + parcel.getTrackNumber());
		emailService.sendEmail(emailToStore);
	} catch (Exception e) {
		System.out.println("Sent email got error: " + e.toString());
	}
	
	
	}
}
