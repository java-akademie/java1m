package ch.jkurs.uebungen;

public class Uebung06a
{

	public static void main(String[] args)
	{
		int erg = mult(5, 66);
		System.out.println(erg);
	}


	static int mult(int a, int b)
	{
		int erg = 0;

		while (a > 0)
		{
			erg += b;
			a--;
		}
		return erg;
	}

}
