package cs544.mum.edu.domain;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import javax.persistence.Embeddable;

@Embeddable
=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
>>>>>>> 3b80cff9d3c62f959c8fafe6add0f081354f2c0c
public class Address {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Long id;
	
	String address;
	String zipCode;
	String state;
<<<<<<< HEAD
	//List<String> phoneNumberList = new ArrayList<String>();
	String phone;
	
	public Address(String address, String zipCode, String state, String phone) {
		this.address = address;
		this.zipCode = zipCode;
		this.state = state;
		this.phone = phone;
	}
=======
	String phoneNumber;
	
>>>>>>> 3b80cff9d3c62f959c8fafe6add0f081354f2c0c
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
<<<<<<< HEAD
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
=======
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
>>>>>>> 3b80cff9d3c62f959c8fafe6add0f081354f2c0c
	}
}
