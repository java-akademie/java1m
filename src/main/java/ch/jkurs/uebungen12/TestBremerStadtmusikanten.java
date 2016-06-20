package ch.jkurs.uebungen12;

public class TestBremerStadtmusikanten
{
	public static void main(String[] args)
	{
		Brueller hund = new Hund();
		Brueller katze = new Katze();
		Brueller hahn = new Hahn();
		Brueller esel = new Esel();

		machtMusik(new Brueller[] { esel, hund, katze, hahn });
		machtMusik(esel, hund, katze, hahn, hahn);
	}


	static void machtMusik(Brueller... b)
	{
		System.out.println();
		for (int i = 0; i < b.length; i++)
		{
			b[i].bruellen();
		}
	}
}
