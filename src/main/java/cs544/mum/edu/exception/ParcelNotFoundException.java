package cs544.mum.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Parcel found.")
public class ParcelNotFoundException extends RuntimeException {
	
	private String message;
	
	public ParcelNotFoundException(String message) {
		this.message = message;
	}

}
