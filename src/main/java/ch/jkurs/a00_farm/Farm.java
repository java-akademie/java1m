package ch.jkurs.a00_farm;

import ch.jmildner.tools.MyTools;

public class Farm
{
	public static void main(String[] args) throws Exception
	{
		int koepfe = MyTools.getInteger("bitte Koepfe eingeben > ", 0,
				1000000);

		String prompt = String.format(
				"bitte beine zwischen %d und %d eingeben > ",
				koepfe * 2, koepfe * 4);

		int beine = 0;

		while (true)
		{
			beine = MyTools.getInteger(prompt, koepfe * 2, koepfe * 4);

			if (!(beine % 2 == 0))
			{
				System.out.print(
						"Anzahl Beine ist keine gerade Zahl .... ");
			}
			else
				break;
		}
		int huehner = 0;
		int schweine = koepfe;

		while (!(huehner * 2 + schweine * 4 == beine))
		{
			huehner++;
			schweine--;
		}

		System.out.printf("der Bauer hat %d Huehner und %d Schweine.\n",
				huehner, schweine);
	}
}
