package ch.jkurs.uebungen;

public class Uebung12xTestBremerStadtmusikanten2
{
	public static void main(String[] args)
	{
		Uebung12Brueller hund = new Uebung12Hund();
		Uebung12Brueller katze = new Uebung12Katze();
		Uebung12Brueller hahn = new Uebung12Hahn();
		Uebung12Brueller esel = new Uebung12Esel();

		machtMusik(new Uebung12Brueller[] { esel, hund, katze, hahn });
		machtMusik(esel, hund, katze, hahn, hahn);
	}


	static void machtMusik(Uebung12Brueller... b)
	{
		System.out.println();
		for (int i = 0; i < b.length; i++)
		{
			b[i].bruellen();
		}
	}
}
