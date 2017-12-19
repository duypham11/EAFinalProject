package cs544.mum.edu.model;

import java.io.Serializable;
import java.util.List;

public class TrackParcelDTO implements Serializable {
	
	private String trackingNumber;
	private String customerName;
	private String delieveryAddress;
	private String delieveryStatus;
	private List<String> historyLog;
	
	
	
	
	
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


	public List<String> getHistoryLog() {
		return historyLog;
	}
	public void setHistoryLog(List<String> historyLog) {
		this.historyLog = historyLog;
	}
	
}
