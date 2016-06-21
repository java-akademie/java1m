package ch.jkurs.uebungen;

public class Uebung12xTestGruseligesUngeheuer
{
	public static void main(String[] args)
	{
		/**
		 * anonyme innere Klasse
		 */
		Uebung12Brueller gruseligesUngeheuer = new Uebung12Brueller()
		{
			@Override
			public void bruellen()
			{
				System.out.println("uuuuuaaaaaahhhhhhhhhhhhhhh");
			}
		};

		gibLaut(gruseligesUngeheuer);
	}


	private static void gibLaut(Uebung12Brueller b)
	{
		b.bruellen();
	}
}
