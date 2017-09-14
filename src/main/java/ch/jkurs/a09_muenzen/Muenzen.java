package ch.jkurs.a09_muenzen;

import java.io.FileNotFoundException;

import ch.jmb.tools.StoppUhr;
import ch.jmb.tools.TextFile;

/**
 * 
 * @author johann
 * 
 */
public class Muenzen
{
	static boolean debug = false;

	static int gb = 20000; // 22198;
	static int gg = 500000; // 379644;


	static int c100 = 0;
	static int c50 = 0;
	static int c10 = 0;
	static int c5 = 0;
	static int c2 = 0;
	static int c1 = 0;

	static int g100 = 750;
	static int g50 = 780;
	static int g10 = 410;
	static int g5 = 392;
	static int g2 = 306;
	static int g1 = 230;

	static int mx100 = Math.min(gb / 100, gg / g100);
	static int mx50 = Math.min(gb / 50, gg / g50);
	static int mx10 = Math.min(gb / 10, gg / g10);
	static int mx5 = Math.min(gb / 5, gg / g5);
	static int mx2 = Math.min(gb / 2, gg / g2);
	static int mx1 = Math.min(gb / 1, gg / g1);

	static int loesungen = 0;

	static int st100 = 0;
	static int st50 = 0;
	static int st10 = 0;
	static int st5 = 0;
	static int st2 = 0;
	static int st1 = 0;

	static TextFile tf;


	private static void ausgabe(String text, boolean debug)
	{

		if (loesungen % 1000 == 0)
			if (debug)
			{
				tf.printLine(loesungen + ". Loesung " + c100 + " " + c50
						+ " " + c10 + " " + c5 + " " + c2 + " " + c1);
				System.out.printf(
						"%30s %3d %3d %3d %3d %3d %3d "
								+ "loesungen: %3d betrag: %5d gewicht: %6d \n",
						text, c100, c50, c10, c5, c2, c1, loesungen,
						betrag(), gewicht());
			}
	}


	private static int betrag()
	{
		return c1 * 1 + c2 * 2 + c5 * 5 + c10 * 10 + c50 * 50
				+ c100 * 100;
	}


	private static int gewicht()
	{
		return c1 * g1 + c2 * g2 + c5 * g5 + c10 * g10 + c50 * g50
				+ c100 * g100;
	}


	private static boolean loesung()
	{
		if ((betrag() == gb) && (gewicht() == gg))
		{
			loesungen++;
			ausgabe("loesung: ", true);
			return true;
		}
		else
		{
			return false;
		}
	}


	private static boolean loesungMoeglich1()
	{
		if (loesung())
			return true;

		if (ueberschritten1())
			return false;
		else
			return true;
	}


	private static boolean loesungMoeglich10()
	{
		if (loesung())
			return true;

		if (ueberschritten10())
			return false;
		else
			return true;
	}


	private static boolean loesungMoeglich100()
	{
		if (loesung())
			return true;

		if (ueberschritten100())
			return false;
		else
			return true;
	}


	private static boolean loesungMoeglich2()
	{
		if (loesung())
			return true;

		if (ueberschritten2())
			return false;
		else
			return true;
	}


	private static boolean loesungMoeglich5()
	{
		if (loesung())
			return true;

		if (ueberschritten5())
			return false;
		else
			return true;
	}


	private static boolean loesungMoeglich50()
	{
		if (loesung())
			return true;

		if (ueberschritten50())
			return false;
		else
			return true;
	}


	public static void main(String[] args) throws FileNotFoundException
	{
		tf = new TextFile("erg.txt", 'o');

		System.out.printf("%d,%d,%d,%d,%d,%d \n", mx100, mx50, mx10,
				mx5, mx2, mx1);

		StoppUhr stoppUhr = new StoppUhr();

		for (c100 = st100; c100 >= 0; c100--)
		{
			if (!loesungMoeglich100())
			{
				ausgabe("loesung nicht moeglich 100: ", debug);
				c100 = 0;
				break;
			}
			for (c50 = st50, st50 = 0; c50 <= mx50; c50++)
			{
				if (!loesungMoeglich50())
				{
					ausgabe("loesung nicht moeglich 50: ", debug);
					c50 = 0;
					break;
				}
				for (c10 = st10, st10 = 0; c10 <= mx10; c10++)
				{
					if (!loesungMoeglich10())
					{
						ausgabe("loesung nicht moeglich 10: ", debug);
						c10 = 0;
						break;
					}
					for (c5 = st5, st5 = 0; c5 <= mx5; c5++)
					{
						if (!loesungMoeglich5())
						{
							ausgabe("loesung nicht moeglich 5: ",
									debug);
							c5 = 0;
							break;
						}
						for (c2 = st2, st2 = 0; c2 <= mx2; c2++)
						{
							if (!loesungMoeglich2())
							{
								ausgabe("loesung nicht moeglich 2: ",
										false);
								c2 = 0;
								break;
							}
							c1 = 0;
							c1 = gb - betrag();
							for (; c1 <= mx1; c1++)
							{
								if (!loesungMoeglich1())
								{
									ausgabe("loesung nicht moeglich 1: ",
											debug);
									c1 = 0;
									break;
								}
							}
						}
					}
				}
			}
		}

		// stoppUhr..stopp();
		System.out.println(stoppUhr.toString());

		System.out.println("Anzahl Loesungen:" + loesungen);
		tf.printLine("Anzahl Loesungen:" + loesungen);
		tf.close();

		System.out.println("fertig");
	}


	private static boolean ueberschritten1()
	{
		// gewicht ueberschritten ?
		if (c1 * g1 + c2 * g2 + c5 * g5 + c10 * g10 + c50 * g50
				+ c100 * g100 > gg)
			return true;

		// betrag ueberschritten ?
		if (c1 * 1 + c2 * 2 + c5 * 5 + c10 * 10 + c50 * 50
				+ c100 * 100 > gb)
			return true;

		return false;
	}


	private static boolean ueberschritten10()
	{
		// gewicht ueberschritten ?
		if (c10 * g10 + c50 * g50 + c100 * g100 > gg)
			return true;

		// betrag ueberschritten ?
		if (c10 * 10 + c50 * 50 + c100 * 100 > gb)
			return true;

		// betrag kann nicht mehr erreicht werden
		if (c50 * 50 + c100 * 100 + 18230 < gb)
			return true;

		return false;

	}


	private static boolean ueberschritten100()
	{
		// gewicht ueberschritten ?
		if (c100 * g100 > gg)
			return true;

		// betrag ueberschritten ?
		if (c100 * 100 > gb)
			return true;

		return false;
	}


	private static boolean ueberschritten2()
	{
		// gewicht ueberschritten ?
		if (c2 * g2 + c5 * g5 + c10 * g10 + c50 * g50
				+ c100 * g100 > gg)
			return true;

		// betrag ueberschritten ?
		if (c2 * 2 + c5 * 5 + c10 * 10 + c50 * 50 + c100 * 100 > gb)
			return true;

		// betrag kann nicht mehr erreicht werden
		if (c5 * 5 + c10 * 10 + c50 * 50 + c100 * 100 + 1650 < gb)
			return true;

		return false;
	}


	private static boolean ueberschritten5()
	{
		// gewicht ueberschritten ?
		if (c5 * g5 + c10 * g10 + c50 * g50 + c100 * g100 > gg)
			return true;

		// betrag ueberschritten ?
		if (c5 * 5 + c10 * 10 + c50 * 50 + c100 * 100 > gb)
			return true;

		// betrag kann nicht mehr erreicht werden
		if (c10 * 10 + c50 * 50 + c100 * 100 + 8980 < gb)
			return true;

		return false;
	}


	private static boolean ueberschritten50()
	{
		// gewicht ueberschritten ?
		if (c50 * g50 + c100 * g100 > gg)
			return true;

		// betrag ueberschritten ?
		if (c50 * 50 + c100 * 100 > gb)
			return true;

		return false;
	}

}
