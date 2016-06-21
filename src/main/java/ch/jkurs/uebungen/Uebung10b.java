package ch.jkurs.uebungen;


public class Uebung10b
{
	static Uebung10Person p1;
	static Uebung10Person p2;
	static Uebung10Person p3;


	public static void main(String[] args)
	{
		// teil 1
		p1 = new Uebung10Person();
		p1.show();
		p2 = new Uebung10Person();
		p2.show();

		if (p1.equals(p2))
		{
			System.out.println(" p1 equals p2");
		}
		else
		{
			System.out.println(" p1 not equals p2");
		}

		// teil 2
		p3 = new Uebung10Person("123~max~biel");
		p3.show();
	}
}
