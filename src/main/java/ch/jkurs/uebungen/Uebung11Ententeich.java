package ch.jkurs.uebungen;

public class Uebung11Ententeich
{
	public static void main(String[] args)
	{
		Uebung11Ente ste = new Uebung11Stockente();
		Uebung11Ente rke = new Uebung11Rotkopfente();

		Uebung11Ente ungeheuer = new Uebung11Ente()
		{
			@Override
			void show()
			{
				System.out.println("ich bin das Entenungeheuer");
			}


			@Override
			void quacken(int anz)
			{
				for (int i = 1; i <= anz; i++)
				{
					System.out.println("uuuhhhaaaaquaaaaaak");
				}
			}
		};
		
		life(ste, 3);
		life(rke);
		life(ungeheuer);
		life(ungeheuer, 2);
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
