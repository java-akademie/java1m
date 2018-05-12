package ch.java_akademie.message;

import org.apache.log4j.Logger;

import ch.jmildner.tools.MyTools;

public class Test
{
	static Logger log = Logger.getLogger(Test.class);


	public static void main(String[] args)
	{
		MyTools.uebOut("eine Ueberschrift", 3);

		log.info("eine Information");

		log.fatal("ein fataler Fehler");

		log.error("eine Errormeldung");

		log.warn("eine Warnmeldung");

		System.out.println((Messages.getString("start"))); //$NON-NLS-1$
		System.out.println((Messages.getString("start2"))); //$NON-NLS-1$
		String s = Messages.getString("hallo"); //$NON-NLS-1$
		String x = Messages.getString("hallo"); //$NON-NLS-1$
		String y = Messages.getString("franz"); //$NON-NLS-1$
		System.out.println(s);
		System.out.println(x);
		System.out.println(y);

		MyTools.untOut("eine Unterschrift", 3);
	}
}

