package cs544.mum.edu.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class TrackParcelDTO implements Serializable {
	
	private String trackingNumber;
	private String customerName;
	private String delieveryAddress;
	private String delieveryStatus;
	
	
	
	
	
	public TrackParcelDTO(String trackingNumber, String customerName, String delieveryAddress,
			String delieveryStatus) {
		this.trackingNumber = trackingNumber;
		this.customerName = customerName;
		this.delieveryAddress = delieveryAddress;
		this.delieveryStatus = delieveryStatus;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDelieveryAddress() {
		return delieveryAddress;
	}
	public void setDelieveryAddress(String delieveryAddress) {
		this.delieveryAddress = delieveryAddress;
	}
	public String getDelieveryStatus() {
		return delieveryStatus;
	}
	public void setDelieveryStatus(String delieveryStatus) {
		this.delieveryStatus = delieveryStatus;
	}
}
