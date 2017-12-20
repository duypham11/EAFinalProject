package cs544.mum.edu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import cs544.mum.edu.domain.Parcel;
import cs544.mum.edu.domain.ParcelHistory;
import cs544.mum.edu.service.EmailService;
import cs544.mum.edu.service.ParcelHistoryService;
import cs544.mum.edu.service.ParcelService;

@Component
@Aspect
@EnableAspectJAutoProxy
@PropertySource("classpath:email.properties")
public class AdminAspect {
	
	 @Autowired
	 private Environment env;
	
	@Autowired
	EmailService emailService;
	
	@After("execution(public * cs544.mum.edu.service.UsernameService.enableUser(..))")
	public void sendEmailOnApproval(JoinPoint joinpoint){
		Object[] args = joinpoint.getArgs();
		String username = (String) args[0];
		SimpleMailMessage approvalEmail = new SimpleMailMessage();
		approvalEmail.setFrom(env.getProperty("email.username"));
		approvalEmail.setTo(username);
		approvalEmail.setSubject("Signup Approval");
		approvalEmail.setText("Hello "+username+", your signup request has been approved");
		emailService.sendEmail(approvalEmail);
	}

}
