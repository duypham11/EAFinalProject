package cs544.mum.edu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import cs544.mum.edu.domain.Email;
import cs544.mum.edu.repository.EmailRepsitory;
import cs544.mum.edu.service.EmailService;
@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	JavaMailSender sender;
	
	@Autowired
	EmailRepsitory emailRepository;
	
	@Override
	@PreAuthorize("hasRole('ROLE_STORE') or hasRole('ROLE_ADMIN')")
	public void sendEmail(SimpleMailMessage email) {
		// TODO Auto-generated method stub
		sender.send(email);
	}
	
	@Override
	public Email save(Email email) {
		// TODO Auto-generated method stub
		return this.emailRepository.save(email);
	}
	

}
