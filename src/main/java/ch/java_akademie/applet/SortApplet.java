package ch.java_akademie.applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortApplet extends Applet implements ActionListener
{
	private static final long serialVersionUID = 1L;

	String[] stringArray = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n" };
	ArrayList<String> stringArrayList = new ArrayList<String>(Arrays.asList(stringArray));

	TextField[] tf;
	Button b1, b2, b3;
	Panel p1;


	public void init()
	{
		makeTheLayout();
		addTheListener();
		this.setSize(300, 500);
	}


	void makeTheLayout()
	{
		p1 = new Panel();

		p1.setLayout(new GridLayout(stringArray.length + 3, 1));

		tf = new TextField[stringArray.length];

		for (int i = 0; i < stringArray.length; i++)
		{
			tf[i] = new TextField(stringArray[i]);
			p1.add(tf[i]);
		}

		b1 = new Button("sort");
		b2 = new Button("merge");

		p1.add(b1);
		p1.add(b2);

		add(p1);
	}


	void addTheListener()
	{
		b1.addActionListener(this);
		b2.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == b1)
		{
			sortieren();
		}
		else
			if (e.getSource() == b2)
			{
				mischen();
			}
			else
				if (e.getSource() == b3)
				{
					zeigen();
				}
	}


	private void zeigen()
	{
		for (int i = 0; i < stringArray.length; i++)
		{
			tf[i].setText(stringArrayList.get(i));
		}
	}


	public void sortieren()
	{
		Collections.sort(stringArrayList);
		zeigen();
	}


	public void mischen()
	{
		Collections.shuffle(stringArrayList);
		zeigen();
	}
}
