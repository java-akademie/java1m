package ch.jkurs.uebungen12;

public class BremerStadtmusikanten
{
	public static void main(String[] args)
	{
		Esel esel = new Esel();
		Hund hund = new Hund();
		Katze katze = new Katze();
		Hahn hahn = new Hahn();

		gibLaut(hahn);
		gibLaut(katze);
		gibLaut(hund);
		gibLaut(esel);

	}


	private static void gibLaut(Brueller b)
	{
		b.bruellen();
	}
}
