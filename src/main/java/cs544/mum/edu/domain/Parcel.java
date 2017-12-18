package cs544.mum.edu.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.Email;
import cs544.mum.edu.domain.Rider;

@Entity
public class Parcel implements Serializable{

	private static final long serialVersionUID = -3560539622417210365L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//private String address;
	@Embedded
	private Address address;
	
	@Email(message="email is required")
	private String email;
	
	private String customerName;
	
	private String trackNumber;
	
	//@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OneToOne
	@JoinColumn(name = "status_id") 
	private ParcelStatus status;
		
	//@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "store_id") 
	private Store store;
	
	//@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "rider_Id") 
	private Rider rider;
	
	//constraint to deliver
//	Date available;
//	Date deliver;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}
	
	public String getAddressAsString() {
		return this.address.getAddress() + ", " + this.address.getZipCode() + ", "+ this.address.getState();
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
	}

	public ParcelStatus getStatus() {
		return status;
	}

	public void setStatus(ParcelStatus status) {
		this.status = status;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
