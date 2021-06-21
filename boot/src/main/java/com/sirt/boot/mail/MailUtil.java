package com.sirt.boot.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MailUtil {
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail() {
		log.info("Preparing Simple Message");
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo("shailtinu2000@gmail.com","kalawati.ambe12@gmail.com");
		msg.setSubject("Testing From Ambe Kalawati");
		msg.setText("Hi\n This is Test Mail from Ambe Kalawati");
		mailSender.send(msg);
		log.info("Mail has been sent");
	}

	public void sendEmailWithAttachment() {
		log.info("Preparing mail with attachment");
		MimeMessage createMimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper=new MimeMessageHelper(createMimeMessage,true);
			String[] recepients= {"shailtinu2000@gmail.com","kalawati.ambe12@gmail.com","shradha.jadiya1999@gmail.com","anjalijatav28@gmail.com"};
		    helper.setTo(recepients);
			helper.setSubject("Testing From Ambe kalawati");
			helper.setText("Hi\n This is Test Mail from Ambe Kalawati");
			helper.addAttachment("Mylearning java.scm",new ClassPathResource("learning java.scm"));
			mailSender.send(createMimeMessage);
			log.info("Attachment has been sent");
		} catch (MessagingException e) {
			log.error("some exception occurs while sending attachment {}",e.getMessage());
		}
		
	}
}