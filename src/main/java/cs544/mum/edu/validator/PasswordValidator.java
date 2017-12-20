package cs544.mum.edu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cs544.mum.edu.domain.Rider;
import cs544.mum.edu.domain.Store;

@Component
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Rider.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userCredentials.password", "required.password", "");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userCredentials.verifyPassword", "required.verifyPassword", "");
		
		if(target instanceof Rider) {
			Rider rider = (Rider) target;
			if (!(rider.getUserCredentials().getPassword().equals(rider.getUserCredentials().getVerifyPassword()))) {
				errors.rejectValue("userCredentials.password", "notmatch.password");
			}
		}
		
		if(target instanceof Store) {
			Store store = (Store) target;
			if (!(store.getUserCredentials().getPassword().equals(store.getUserCredentials().getVerifyPassword()))) {
				errors.rejectValue("userCredentials.password", "notmatch.password");
			}
		}
		
	}
	

}
