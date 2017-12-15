package cs544.mum.edu.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Rider implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private Long rider_Id;
	
	@Column(length = 16)
	@NotNull
	@Size(min = 4, max = 16, message= "{Size.firstName.validation}")
	private String firstName;
	
	@Column(length = 16)
	@NotNull
	@Size(min=5, max = 9, message= "{Size.name.validation}")
	private String lastName;
	
	@Email(message="Please provide a valid email address")
	private String email;
	
	@ElementCollection
	Address address;
	
	@ElementCollection
	Rate rate;
	
	@ElementCollection
	List<String> favZipCode;
	
	
	public Rider(String firstName, String lastName, String email, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getFavZipCode() {
		return favZipCode;
	}

	public void addFavZipCode(String zipCode) {
		favZipCode.add(zipCode);
	}
	public void setFavZipCode(List<String> favZipCode) {
		this.favZipCode = favZipCode;
	}

	public float getRate() {
		return rate.rate;
	}

	public float rate(int value) {
		return this.rate.rate(value);
	}
	public void setRate(Rate rate) {
		this.rate = rate;
	}
	
	
}
