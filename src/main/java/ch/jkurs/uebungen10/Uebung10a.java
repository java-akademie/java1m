package ch.jkurs.uebungen10;


public class Uebung10a
{
	public static void main(String[] args)
	{
		Person p1 = new Person(4711, "hugo", "basel");
		Person p2 = new Person(4712, "fritz", "genf");
		Person p3 = new Person(4713, "franz", "bern");
		Person p4 = new Person();
		p1.show();
		p2.show();
		p3.show();
		p4.show();
	}
}
