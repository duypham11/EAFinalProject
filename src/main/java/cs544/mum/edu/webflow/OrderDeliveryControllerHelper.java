package cs544.mum.edu.webflow;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import cs544.mum.edu.domain.Rider;

@Component
public class OrderDeliveryControllerHelper {

//	@Autowired
//	OrderDeliveryService orderDeliveryService;
//	
//	@Autowired
//	RiderService riderService;
//	
//	@Autowired
//	RestaurantService restaurantService;
//	
//	@Autowired
//	EmailService emailService;
//	
//	public OrderDelivery saveOrderDelivery(OrderDelivery orderDelivery, Rider rider) {
//		OrderStatus orderStatus = new OrderStatus();
//		orderStatus.setId(new Long(1));
//		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//		Restaurant res =	 restaurantService.findByUsername(username);
//		
//		orderDelivery.setRider(rider);
//		orderDelivery.setStatus(orderStatus);
//		orderDelivery.setRestaurant(res);
//		orderDelivery.setTrackNumber(orderDeliveryService.getNextTrackNo());
//		
//		return orderDeliveryService.save(orderDelivery);
//	}
//	
//	public OrderDelivery initiate() {
//		OrderDelivery orderDeliver = new OrderDelivery();
//		return orderDeliver;
//	}
//	
//	public Rider getAvailableRider(){
//		List<Rider> list = riderService.getAvailableRider();
//
//		return list.get(0);
//	}
//	
//	public void sendOutNotifcation(OrderDelivery orderDelivery, Rider rider) {
//		
//		//one copy to customer 
//		SimpleMailMessage emailToCust = new SimpleMailMessage();
//		
//		emailToCust.setTo(orderDelivery.getEmail());
//		emailToCust.setSubject("Order Complete " + orderDelivery.getTrackNumber());
//		emailToCust.setText("your tracking number is " + orderDelivery.getTrackNumber());
//		emailService.sendEmail(emailToCust);
//		
//		//one copy for rider
//		SimpleMailMessage emailToRider = new SimpleMailMessage();
//		System.out.println("rider email " + rider.getEmail());
//		
//		emailToRider.setTo(rider.getEmail());
//		emailToRider.setSubject("Order Delivery Task " + orderDelivery.getTrackNumber());
//		emailToRider.setText("This task is for customer " + orderDelivery.getCustomerName());
//		emailService.sendEmail(emailToRider);
//		
//		//one copy for restaurant owner
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//		Restaurant res =	 restaurantService.findByUsername(username);
//		
//		SimpleMailMessage emailToRestaurant = new SimpleMailMessage();
//		System.out.println("restaurant email " + res.getEmail());
//		
//		emailToRestaurant.setTo(res.getEmail());
//		emailToRestaurant.setSubject("A rider request " + orderDelivery.getTrackNumber());
//		emailToRestaurant.setText("A rider has been assigned to you, " + rider.getFirstName());
//		emailService.sendEmail(emailToRestaurant);
//	}
	
}
