package ch.jkurs.uebungen;

public class Uebung13
{
	enum Suit // Kartenfarbe
	{
		KARO(true), KREUZ(false), PIK(false), HERZ(true);
		boolean red; // karo,herz=true, pik,kreuz=false


		Suit(boolean red)
		{
			this.red = red;
		}


		boolean isRed()
		{
			return red;
		}


		public String toString()
		{
			return name() + ":" + (red ? "red" : "black ");
		}
	}



	public static void main(String[] args)
	{
		Suit karo = Suit.KARO;
		Suit kreuz = Suit.KREUZ;
		Suit pik = Suit.PIK;
		Suit herz = Suit.HERZ;

		System.out.println(karo);
		System.out.println(kreuz);
		System.out.println(pik);
		System.out.println(herz);
	}

}
