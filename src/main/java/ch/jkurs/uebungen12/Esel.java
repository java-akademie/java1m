package ch.jkurs.uebungen12;

public class Esel extends Saeugetier implements Brueller
{
	@Override
	public void bruellen()
	{
		System.out.println("IAH IAH IAH ...");
	}
}
