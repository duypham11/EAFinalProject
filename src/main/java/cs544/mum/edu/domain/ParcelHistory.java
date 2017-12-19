package cs544.mum.edu.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ParcelHistory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	String trackingNumber;
	
	@Column
	String previousState;
	
	@Column
	String currentState;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="timestamp", nullable = false,columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private Date timestamp = new Date();

	@Column
	private String modifiedBy;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrackingNO() {
		return trackingNumber;
	}

	public void setTrackingNO(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getPreviousState() {
		return previousState;
	}

	public void setPreviousState(String previousState) {
		this.previousState = previousState;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
