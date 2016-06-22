package ch.java_akademie.mail;

import java.util.Date;

public class SendMail
{

	public static void main(String[] args) throws Exception
	{

		String to = "johann.mildner@icloud.com";
		String subject = "Test aus einem Java Programm";

		StringBuilder text = new StringBuilder();

		text.append("lieber hans  \n");
		text.append("dies ist ein test aus einem java-programm  \n");
		text.append(
				"ruf bitte an wenn's nicht funktioniert hat :-)  \n");
		text.append("das gegenwärtige Datum ist ");
		text.append(new Date() + "\n\n\n");
		text.append("liebe Grüsse \n\n");
		text.append("johann \n\n");

		MailTool.sendMailHispeed(to, subject,
				text.toString() + "hispeed");
		MailTool.sendMailICloud(to, subject,
				text.toString() + "icloud");

		System.out.println("Done");
	}
}
