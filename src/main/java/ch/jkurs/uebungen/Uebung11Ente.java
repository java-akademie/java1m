package ch.jkurs.uebungen;

public abstract class Uebung11Ente
{
	void fliegen()
	{
		System.out.println("ich fliege ...");
	}


	void quacken()
	{
		quacken(1);
	}


	void quacken(int anz)
	{
		for (int i = 1; i <= anz; i++)
		{
			System.out.println("quack");
		}
	}


	void schwimmen()
	{
		System.out.println("ich schwimme ...");
	}
	
	abstract void show();
}
