package ch.jkurs.uebungen11;

public class Ententeich
{
	public static void main(String[] args)
	{
		Ente ste = new Stockente();
		Rotkopfente rke = new Rotkopfente();


		life(ste,3);
		life(rke);
	}


	private static void life(Ente e, int z)
	{
		e.show();
		e.fliegen();
		e.schwimmen();
		e.quacken(z);

		System.out.println();
	}


	private static void life(Ente e)
	{
		e.show();
		e.fliegen();
		e.schwimmen();
		e.quacken();

		System.out.println();
	}

}
