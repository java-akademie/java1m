package ch.java_akademie.sonstiges;

public class AnonymeKlasseTest
{

	public static void main(String[] args)
	{
		Brueller h = new Hund();
		h.bruellen();

		Brueller ungeheuer = new Brueller()
		{
			// @Override
			public void bruellen()
			{
				System.out.println("schnurr");
			}
		};

		ungeheuer.bruellen();
	}

}



interface Brueller
{
	void bruellen();
}



class Hund implements Brueller
{

	// @Override
	public void bruellen()
	{
		System.out.println("wau wau");
	}

}
