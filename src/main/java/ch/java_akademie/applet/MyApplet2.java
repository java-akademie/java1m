package ch.java_akademie.applet;

import java.applet.Applet;

public class MyApplet2 extends Applet
{
	private static final long serialVersionUID = 1L;


	public void init()
	{
		System.out.println("init aufgerufen");
		add(new MyPanel2());
		this.setSize(600, 400);
	}
}
