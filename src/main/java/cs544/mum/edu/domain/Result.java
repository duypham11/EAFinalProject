package cs544.mum.edu.domain;

public class Result {
	public enum Status {
			FAILURE,
			SUCCESS,
	};
	
	private Status status = Status.FAILURE;
	private String message = "Fail to get data";
	private Object result;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

}
