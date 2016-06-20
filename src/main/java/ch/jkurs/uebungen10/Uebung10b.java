package ch.jkurs.uebungen10;


public class Uebung10b
{
	static Person p1;
	static Person p2;
	static Person p3;


	public static void main(String[] args)
	{
		// teil 1
		p1 = new Person();
		p1.show();
		p2 = new Person();
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
		p3 = new Person("123~max~biel");
		p3.show();
	}
}
