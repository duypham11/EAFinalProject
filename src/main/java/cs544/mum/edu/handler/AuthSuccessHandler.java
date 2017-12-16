package cs544.mum.edu.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        // Get the role of logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        //System.out.println("role is "+ role);

        String redirectUrl = "/login";
        if(role.contains("ROLE_ADMIN")) {
        		redirectUrl = "/admin";
        } else if(role.contains("ROLE_STORE")) {
        		redirectUrl = "/store";
        } else if (role.contains("ROLE_RIDER")) {
        		redirectUrl = "/rider";
        }
        return redirectUrl;
    }
}
