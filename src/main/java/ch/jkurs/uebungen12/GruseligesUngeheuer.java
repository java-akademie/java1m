package ch.jkurs.uebungen12;

public class GruseligesUngeheuer
{
	public static void main(String[] args)
	{
		/**
		 * anonyme innere Klasse
		 */
		Brueller gruseligesUngeheuer = new Brueller()
		{
			@Override
			public void bruellen()
			{
				System.out.println("uuuuuaaaaaahhhhhhhhhhhhhhh");
			}
		};

		gibLaut(gruseligesUngeheuer);
	}


	private static void gibLaut(Brueller b)
	{
		b.bruellen();
	}
}
