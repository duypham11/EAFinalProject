package cs544.mum.edu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ZipCode {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private Long zipCode_Id;
	
	String zipCode;
}
