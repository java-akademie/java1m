package ch.java_akademie.applet1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class MyPanel extends Panel
		implements ActionListener, ItemListener
{
	private static final long serialVersionUID = 1L;

	CheckboxGroup rbg; // radiobuttongroup
	Checkbox rb1, rb2, rb3; // radiobuttons

	Checkbox cb1, cb2, cb3; // checkboxes

	TextField tf1, tf2;
	Button but;
	TextArea ta;


	public MyPanel()
	{
		makeTheLayout();
		addTheListener();
	}


	private void makeTheLayout()
	{
		rbg = new CheckboxGroup();
		rb1 = new Checkbox("rb1", false, rbg);
		rb2 = new Checkbox("rb2", false, rbg);
		rb3 = new Checkbox("rb3", false, rbg);
		cb1 = new Checkbox("cb1", false);
		cb2 = new Checkbox("cb2", false);
		cb3 = new Checkbox("cb3", false);

		tf1 = new TextField("", 20);
		tf2 = new TextField("", 20);

		but = new Button("start");

		ta = new TextArea(5, 70);

		Panel p1;
		p1 = new Panel();

		p1.setLayout(new GridLayout(3, 3));

		p1.add(rb1);
		p1.add(rb2);
		p1.add(rb3);
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		p1.add(tf1);
		p1.add(tf2);
		p1.add(but);

		Panel p2;
		p2 = new Panel();

		p2.setLayout(new FlowLayout());
		p2.add(ta);

		setBackground(Color.yellow);
		setForeground(Color.red);
		setLayout(new BorderLayout());

		add("East", new Label(""));
		add("West", new Label(""));
		add("Center", p1);
		add("South", p2);

	}


	private void addTheListener()
	{
		but.addActionListener(this);
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
	}


	public void actionPerformed(ActionEvent e)
	{
		System.out.println("ae=" + e);

		int a;
		try
		{
			a = Integer.parseInt(tf1.getText());
		}
		catch (Exception ex)
		{
			a = 0;
		}

		int b;
		try
		{
			b = Integer.parseInt(tf2.getText());
		}
		catch (Exception ex)
		{
			b = 0;
		}

		String s = ta.getText();

		s = a + "+" + b + "=" + (a + b) + "\n" + s;

		ta.setText(s);

		tf1.setText("rbZaehler=" + rbZaehler());
		tf2.setText("cbZaehler=" + cbZaehler());
	}


	public void itemStateChanged(java.awt.event.ItemEvent e)
	{
		System.out.println("ie=" + e);

		if (e.getItemSelectable() == rb1)
		{
			tf1.setText("rb1, rbZaehler=" + rbZaehler());
		}

		if (e.getItemSelectable() == rb2)
		{
			tf1.setText("rb2, rbZaehler=" + rbZaehler());
		}

		if (e.getItemSelectable() == rb3)
		{
			tf1.setText("rb3, rbZaehler=" + rbZaehler());
		}



		if (e.getItemSelectable() == cb1)
		{
			tf2.setText("cb1, cbZaehler=" + cbZaehler());
		}

		if (e.getItemSelectable() == cb2)
		{
			tf2.setText("cb2, cbZaehler=" + cbZaehler());
		}

		if (e.getItemSelectable() == cb3)
		{
			tf2.setText("cb3, cbZaehler=" + cbZaehler());
		}
	}


	private int rbZaehler()
	{
		int z = 0;

		if (rb1.getState())
			z = z + 1;
		if (rb2.getState())
			z = z + 2;
		if (rb3.getState())
			z = z + 4;

		return z;
	}


	private int cbZaehler()
	{
		int z = 0;

		if (cb1.getState())
			z = z + 1;
		if (cb2.getState())
			z = z + 2;
		if (cb3.getState())
			z = z + 4;

		return z;
	}
}
