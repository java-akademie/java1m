package ch.jkurs.uebungen12;

public class Hund extends Saeugetier implements Brueller
{
	@Override
	public void bruellen()
	{
		System.out.println("WAU WAU ...");
	}
}
