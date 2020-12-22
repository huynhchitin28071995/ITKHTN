package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javaBeans.MailInfo;

@Controller
public class SendMailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(path = "/send-mail")
	public String sendMail() {
		return "sendMail";
	}
	
	@RequestMapping(value = "/send-mail", method=RequestMethod.POST)
	public String sendMail(@ModelAttribute("obj") MailInfo obj) {
		((JavaMailSenderImpl)mailSender).setUsername(obj.getFrom());
		((JavaMailSenderImpl)mailSender).setPassword(obj.getPassword());
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(obj.getEmail());
		msg.setSubject(obj.getSubject());
		msg.setText(obj.getContent());
		mailSender.send(msg);
		return "sendMail";
	}
}
