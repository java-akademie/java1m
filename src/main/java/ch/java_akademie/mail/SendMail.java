package ch.java_akademie.mail;

import java.util.Date;

public class SendMail
{

	public static void main(String[] args) throws Exception
	{
		test1();
		// testWerner();
	}


	static void testWerner() throws Exception
	{
		String[] to = { "werner.paulus@wpms.de" };
		String[] cc = { "johann.mildner@icloud.com", "johann.mildner@balcab.ch" };
		String[] bcc = { "brigite.mauler@gmx.at" };

		String subject = "Test aus einem Java Programm an Werner Paulus";

		StringBuilder text = new StringBuilder();

		text.append("lieber Werner  \n");
		text.append("dies ist ein test aus einem java-programm  \n");
		text.append("ruf bitte an wenn's nicht funktioniert hat :-)  \n");
		text.append("das gegenwärtige Datum ist ");
		text.append(new Date() + "\n\n\n");
		text.append("liebe Grüsse \n\n");
		text.append("johann \n\n");
		text.append("P.S. ich bin gerade am herumspielen - sorry - loesche die mails einfach \n");
		text.append("aber vielleicht kannst du mails mal gebrauchen \n\n");

		MailTool.sendMailHispeed(to, cc, bcc, subject, text.toString() + "hispeed");
		MailTool.sendMailICloud(to, cc, bcc, subject, text.toString() + "icloud");

		System.out.println("Done");
	}


	private static void test1() throws Exception
	{
		String[] to = { "johann@jmildner.ch" };
		String[] cc = { "johann.mildner@icloud.com" };
		String[] bcc = { "brigita.mauler@gmx.at" };


		String subject = "Test aus einem Java Programm an Johann Mildner";

		StringBuilder text = new StringBuilder();

		text.append("lieber hans  \n");
		text.append("dies ist ein test aus einem java-programm  \n");
		text.append("ruf bitte an wenn's nicht funktioniert hat :-)  \n");
		text.append("das gegenwärtige Datum ist ");
		text.append(new Date() + "\n\n\n");
		text.append("liebe Grüsse \n\n");
		text.append("johann \n\n");


		// MailTool.sendMailGenotec(to,cc,bcc, subject, text.toString()
		// + "genotec");

		System.out.println("xxxxx");

		MailTool.sendMailHispeed(to, cc, bcc, subject, text.toString() + "hispeed");

		System.out.println("Done");
	}
}
