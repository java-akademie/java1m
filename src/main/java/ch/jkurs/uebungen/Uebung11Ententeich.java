package ch.jkurs.uebungen;

public class Uebung11Ententeich
{
	public static void main(String[] args)
	{
		Uebung11Ente ste = new Uebung11Stockente();
		Uebung11Rotkopfente rke = new Uebung11Rotkopfente();


		life(ste,3);
		life(rke);
	}


	private static void life(Uebung11Ente e, int z)
	{
		e.show();
		e.fliegen();
		e.schwimmen();
		e.quacken(z);

		System.out.println();
	}


	private static void life(Uebung11Ente e)
	{
		e.show();
		e.fliegen();
		e.schwimmen();
		e.quacken();

		System.out.println();
	}

}
