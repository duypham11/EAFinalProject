package cs544.mum.edu.interceptor;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class VolunteerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// test interceptor Order		
		System.out.println("INTERCEPTOR PREHANDLE");

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		String userMessage = "Default message from interceptor";

		Principal principal = request.getUserPrincipal();

		if (principal != null) {
			if (request.isUserInRole("Admin_Role") )
				userMessage = "Interceptor: you are admin";
			else 
				userMessage = "Interceptor: not in admin role";
		}
		//modelAndView.getModelMap().addAttribute("intercepterMessage", userMessage);

		return;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
		System.out.println("Calling afterCompletion");
		return;
	}

}
