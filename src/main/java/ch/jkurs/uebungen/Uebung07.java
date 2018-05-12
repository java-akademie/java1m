package ch.jkurs.uebungen;

import ch.jmildner.tools.MyTools;

/**
 * Eingeben von 2 Namen <br>
 * wenn beide gleich, den Namen ausgeben wenn nicht, beide Namen
 * sortiert ausgeben
 * 
 * @author johann
 * 
 */
public class Uebung07
{

	public static void main(String[] args)
	{
		String n1 = MyTools.getString("bitte name1 eingeben > ");
		String n2 = MyTools.getString("bitte name1 eingeben > ");

		if (n1.equals(n2))
		{
			System.out.println(n1);
		}
		else
		{
			if (n1.compareTo(n2) < 0)
			{
				System.out.println(n1 + '\n' + n2);
			}
			else
			{
				System.out.println(n2 + '\n' + n1);
			}
		}
	}

}
