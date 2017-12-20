package cs544.mum.edu.domain;

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

@Entity 
public class Store implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private Long id;
	
	@Size(min = 2, max = 100)
	private String name;
	
	@Size(min = 2, max = 50)
	private String firstName;
	
	@Size(min = 2, max = 50)
	private String lastName;
 	

	@Embedded
	private Address address;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty(message = "Please put something here")
	private String note;
	
	@OneToOne(fetch=FetchType.EAGER) 
 	@JoinColumn(name="username") 
 	Username userCredentials;
	
	public Store() {}
 	
 	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
 
	
 	public Username getUserCredentials() {
		return userCredentials;
	}
	public void setUserCredentials(Username userCredentials) {
		this.userCredentials = userCredentials;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
  }
