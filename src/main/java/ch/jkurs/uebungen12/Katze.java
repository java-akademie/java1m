package ch.jkurs.uebungen12;

public class Katze extends Saeugetier implements Brueller
{
	@Override
	public void bruellen()
	{
		System.out.println("MIAU MIAU ...");
	}
}
