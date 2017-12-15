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
	Address add;
}
