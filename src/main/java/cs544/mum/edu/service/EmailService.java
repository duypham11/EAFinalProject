package cs544.mum.edu.service;

import org.springframework.mail.SimpleMailMessage;

import cs544.mum.edu.domain.Email;

public interface EmailService {
	public void sendEmail(SimpleMailMessage email);
	public Email save(Email email);
}
