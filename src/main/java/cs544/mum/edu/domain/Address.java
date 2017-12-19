package cs544.mum.edu.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	String address;
	String zipCode;
	String state;

	//List<String> phoneNumberList = new ArrayList<String>();
	String phone;
	
	public Address() {}
	
	public Address(String address, String zipCode, String state, String phone) {
		this.address = address;
		this.zipCode = zipCode;
		this.state = state;
		this.phone = phone;
	}

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

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
