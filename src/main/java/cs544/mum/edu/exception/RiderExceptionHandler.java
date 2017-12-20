package cs544.mum.edu.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class RiderExceptionHandler {
	
	@ExceptionHandler(ParcelNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ParcelNotFoundException exception) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		
		return mav;
	}
	


}
