package com.claim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender {
	@Autowired
	private JavaMailSender emailSender;
	
	public void sendEmail(String to, String subject, String message) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(message);
		emailSender.send(mail);
	}
}
