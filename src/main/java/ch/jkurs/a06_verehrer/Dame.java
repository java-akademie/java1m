package ch.jkurs.a06_verehrer;

import ch.jmb.tools.MyTools;

public class Dame
{
	Verehrer verehrer;


	void addVerehrer(Verehrer v)
	{
		verehrer = v;
	}


	void doIt()
	{
		while (true)
		{
			MyTools.sleep(MyTools.getRandom(1000, 10000));

			verehrer.anruf();
		}
	}
}
