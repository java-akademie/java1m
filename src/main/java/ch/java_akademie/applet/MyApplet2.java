package ch.java_akademie.applet1;

import java.applet.Applet;

public class MyApplet extends Applet
{
	private static final long serialVersionUID = 1L;


	public void init()
	{
		System.out.println("init aufgerufen");
		add(new MyPanel());
		this.setSize(600, 400);
	}
}
