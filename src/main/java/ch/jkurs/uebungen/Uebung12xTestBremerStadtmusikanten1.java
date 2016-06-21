package ch.jkurs.uebungen;

public class Uebung12xTestBremerStadtmusikanten1
{
	public static void main(String[] args)
	{
		Uebung12Esel esel = new Uebung12Esel();
		Uebung12Hund hund = new Uebung12Hund();
		Uebung12Katze katze = new Uebung12Katze();
		Uebung12Hahn hahn = new Uebung12Hahn();

		gibLaut(hahn);
		gibLaut(katze);
		gibLaut(hund);
		gibLaut(esel);

	}


	private static void gibLaut(Uebung12Brueller b)
	{
		b.bruellen();
	}
}
