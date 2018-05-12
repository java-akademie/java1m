package ch.jmildner.java1;

import org.apache.log4j.Logger;

import ch.jmildner.tools.MyTools;


public class App
{
	static Logger log = Logger.getLogger(App.class);


	public static void main(String[] args)
	{
		System.out.println("Hello World!");

		MyTools.uebOut("eine Ueberschrift");

		log.info("eine Information");

		log.fatal("ein fataler Fehler");

		log.error("eine Errormeldung");

		log.warn("eine Warnmeldung");

		MyTools.untOut("eine Unterschrift");
	}
}
