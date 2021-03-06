package controllers;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendmail.html")
public class SendMailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SendMailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/mail/mail.jsp").forward(request, response);
	}

	private static boolean send(String to, String subject, String text) {
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.user", "huynhchitinjavatest@gmail.com");
		props.setProperty("mail.smtp.password", "JavaTest");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("huynhchitinjavatest@gmail.com", "JavaTest");
			}
		});
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom();
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText(text);
			Transport.send(msg);
			return true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String msg = "Failed";
		if (send(request.getParameter("email"), request.getParameter("subject"), request.getParameter("content"))) {
			msg = "Success";
		}
		request.setAttribute("msg", msg);
		doGet(request, response);
	}

}
