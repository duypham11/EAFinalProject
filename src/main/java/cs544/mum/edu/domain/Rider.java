package cs544.mum.edu.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	

	@Embedded
	private Address address;
	
	
	private String photoURL;
	
	@OneToOne(fetch=FetchType.EAGER) 
 	@JoinColumn(name="username") 
 	Username userCredentials;
	
	public Rider() {}
	
	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public Username getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(Username userCredentials) {
		this.userCredentials = userCredentials;
	}

	public List<Parcel> getParcelList() {
		return parcelList;
	}

	public void setParcelList(List<Parcel> parcelList) {
		this.parcelList = parcelList;
	}

	public void addParcel(Parcel parcel) {
		this.parcelList.add(parcel);
	}
	
	public void removeParcel(Parcel parcel) {
		if (this.parcelList.isEmpty()||this.parcelList.indexOf(parcel)<0)
			return;
		this.parcelList.remove(parcel);
	}
	@Embedded
	private Rate rate;
	
	@ElementCollection
	private List<String> favZipCode;

	@OneToMany(mappedBy = "rider")
	private List<Parcel> parcelList;
	
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

	public float getRate() {
		return rate.rate;
	}

	public float rate(int value) {
		return this.rate.rate(value);
	}
	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public Long getRider_Id() {
		return rider_Id;
	}

	public void setRider_Id(Long rider_Id) {
		this.rider_Id = rider_Id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getFavZipCode() {
		return favZipCode;
	}

	public void setFavZipCode(List<String> favZipCode) {
		this.favZipCode = favZipCode;
	}
	
	
}
