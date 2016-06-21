package ch.jkurs.uebungen;

public class Uebung12Katze extends Uebung12Saeugetier implements Uebung12Brueller
{
	@Override
	public void bruellen()
	{
		System.out.println("MIAU MIAU ...");
	}
}
