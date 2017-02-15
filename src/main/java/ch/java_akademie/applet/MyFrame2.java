package ch.java_akademie.applet;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame2
{
	Frame frame;


	public MyFrame2(String feld)
	{

		frame = new Frame("Frame");

		frame.add(new MyPanel2());

		frame.setSize(500, 300);
		frame.setLocation(200, 100);
		frame.pack();
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.out.println("Window geschlossen" + e);
				System.exit(0);
			}
		});
	}


	public static void main(String[] args)
	{
		System.out.println("start main");
		new MyFrame2("mein Frame");
	}
}
