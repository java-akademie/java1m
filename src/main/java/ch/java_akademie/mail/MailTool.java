package ch.java_akademie.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailTool
{
	public static void sendMailICloud(final String[] TO, final String[] CC, final String[] BCC,
			final String SUBJECT, final String TEXT) throws Exception
	{
		final String HOST = "smtp.icloud.com";
		final String USER = "johann.mildner@icloud.com";
		final String FROM = "noreply@icloud.com";
		final String PASSWORD = "Vesna-0808";

		sendMail(TO, CC, BCC, SUBJECT, TEXT, HOST, USER, FROM, PASSWORD);

	}


	public static void sendMailHispeed(final String[] TO, final String[] CC, final String[] BCC,
			final String SUBJECT, final String TEXT) throws Exception
	{
		final String HOST = "smtp.hispeed.ch";
		final String USER = "johann.mildner@balcab.ch";
		final String FROM = "noreply@balcab.ch";
		final String PASSWORD = "Vesna-0808";

		sendMail(TO, CC, BCC, SUBJECT, TEXT, HOST, USER, FROM, PASSWORD);
	}


	public static void sendMailGenotec(final String[] TO, final String[] CC, final String[] BCC,
			final String SUBJECT, final String TEXT) throws Exception
	{
		final String HOST = "smtp.genotec.ch";
		final String USER = "johann@jmildner.ch";
		final String FROM = "noreply@jmildner.ch";
		final String PASSWORD = "Vesna-0808";

		sendMail(TO, CC, BCC, SUBJECT, TEXT, HOST, USER, FROM, PASSWORD);
	}


	public static void sendMail(final String[] TO, final String[] CC, final String[] BCC,
			final String SUBJECT, final String TEXT, final String HOST, final String USER,
			final String FROM, final String PASSWORD) throws Exception
	{
		Properties props = new Properties();
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.socketFactory.port", "25");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");

		Authenticator auth = new Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(USER, PASSWORD);
			}
		};

		Session session = Session.getDefaultInstance(props, auth);

		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(FROM));

		
		for (String recipient : TO)
		{
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
		}

		for (String recipient : CC)
		{
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(recipient));
		}

		for (String recipient : BCC)
		{
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(recipient));
		}

	
		
		message.setSubject(SUBJECT);

		message.setText(TEXT);

		Transport.send(message);

	}

}
