package ch.jkurs.uebungen;


public class Uebung10a
{
	public static void main(String[] args)
	{
		Uebung10Person p1 = new Uebung10Person(4711, "hugo", "basel");
		Uebung10Person p2 = new Uebung10Person(4712, "fritz", "genf");
		Uebung10Person p3 = new Uebung10Person(4713, "franz", "bern");
		Uebung10Person p4 = new Uebung10Person();
		p1.show();
		p2.show();
		p3.show();
		p4.show();
	}
}
