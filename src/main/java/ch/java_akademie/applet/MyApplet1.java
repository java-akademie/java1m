package ch.java_akademie.applet;

import java.applet.Applet;

public class MyApplet1 extends Applet
{

	private static final long serialVersionUID = 1L;

 
	public void init()
	{
		System.out.println("init aufgerufen");
		add(new MyPanel1());
		this.setSize(600, 400);
	}


	public static void main(String args[])
	{
		System.out.println();
		System.out.println("dies ist ein applet!");
		System.out.println("es kann nicht als Applikation");
		System.out.println("aufgerufen werden");
		System.out.println();
		System.out.println("benutzen Sie den appletviewer");
		System.out.println();
		System.out.println("appletviewer testApplet.html");
		System.out.println();
	}

}
