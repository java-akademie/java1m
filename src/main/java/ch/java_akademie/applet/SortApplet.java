package ch.java_akademie.applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ch.java_akademie.tools.MyTools;

public class SortApplet extends Applet implements ActionListener
{
	private static final long serialVersionUID = 1L;

	String[] nl = { "a", "b", "c", "d", "e"

			, "f", "g", "h", "i", "j", "k", "l", "m", "n"};
	TextField[] tf;
	Button b1, b2, b3;
	Panel p1;


	public void init()
	{
		makeTheLayout();
		addTheListener();
		this.setSize(300, 800);
	}


	void makeTheLayout()
	{
		p1 = new Panel();

		p1.setLayout(new GridLayout(nl.length + 3, 1));

		tf = new TextField[nl.length + 2];

		for (int i = 0; i < nl.length; i++)
		{
			tf[i] = new TextField(nl[i]);
			p1.add(tf[i]);
		}

		b1 = new Button("sort");
		b2 = new Button("merge");
		b3 = new Button("show");

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);

		add(p1);
	}


	void addTheListener()
	{
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
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
		MyTools.sleep(1000);

		for (int i = 0; i < nl.length; i++)
		{
			tf[i].setText(nl[i]);
		}
	}


	public void sortieren()
	{
		Arrays.sort(nl);
		zeigen();
	}


	public void mischen()
	{
		shuffleArray(nl);
		zeigen();
	}


	public void shuffleArray(String[] ar)
	{
		Random rnd = ThreadLocalRandom.current();
		for (int i = 0; i < ar.length; i++)
		{
			int index = rnd.nextInt(i + 1);
			System.out.println(index);
			String a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

}
