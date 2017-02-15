package ch.java_akademie.applet;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel1 extends Panel
{
	private static final long serialVersionUID = 1L;
	Label lb = new Label("name");
	TextField tf = new TextField(40);
	Button b1 = new Button("OK");
	Button b2 = new Button("NOK");


	public MyPanel1()
	{
		makeTheLayout();
		addTheListener();
	}


	private void makeTheLayout()
	{
		add(lb);
		add(tf);
		add(b1);
		add(b2);

		setBackground(Color.yellow);
		setForeground(Color.red);

		setSize(500, 300);
		setLocation(200, 100);
		setVisible(true);
	}


	private void addTheListener()
	{
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tf.setText("ok gedrueckt");
			}
		});

		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tf.setText("nok gedrueckt");
			}
		});
	}
}
