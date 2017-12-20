package cs544.mum.edu.model;

public class CommonResponseDTO {

	private double responseCode;
	private Object responseObject;
	private String responseMessage;
	
	
	
	public CommonResponseDTO() {
		super();
	}
	public CommonResponseDTO(double responseCode, Object responseObject, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseObject = responseObject;
		this.responseMessage = responseMessage;
	}
	public double getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(double responseCode) {
		this.responseCode = responseCode;
	}
	public Object getResponseObject() {
		return responseObject;
	}
	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	

	@Override
	public String toString() {
		return "CommonResponseDTO [responseCode=" + responseCode + ", responseObject=" + responseObject
				+ ", responseMessage=" + responseMessage + "]";
	}
	
	
}
