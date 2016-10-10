package ch.java_akademie.lotto;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Lotto2Frame extends JFrame
{
	private static final long serialVersionUID = 1L;


	public Lotto2Frame()
	{
		super("Lotto2");
		Container cont = getContentPane();
		cont.add(new Lotto2Panel(this));
		setLocation(200, 100);
		packAndShow();
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}


	public void packAndShow()
	{
		pack();
		setVisible(true);
	}


	public static void main(String[] args)
	{
		new Lotto2Frame();
	}
}
