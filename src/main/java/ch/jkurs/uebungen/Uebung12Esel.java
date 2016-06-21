package ch.jkurs.uebungen;

public class Uebung12Esel extends Uebung12Saeugetier implements Uebung12Brueller
{
	@Override
	public void bruellen()
	{
		System.out.println("IAH IAH IAH ...");
	}
}
