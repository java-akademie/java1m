package ch.jkurs.uebungen;

public class Uebung12Hund extends Uebung12Saeugetier implements Uebung12Brueller
{
	@Override
	public void bruellen()
	{
		System.out.println("WAU WAU ...");
	}
}
