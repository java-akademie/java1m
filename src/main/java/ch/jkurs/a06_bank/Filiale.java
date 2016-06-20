package ch.jkurs.a06_bank;

public class Filiale extends Thread
{
	private long zaehler;
	private String name;
	private Konto konto;


	public Filiale(String name, Konto konto)
	{
		this.name = name;
		this.konto = konto;
	}


	@Override
	public void run()
	{
		while (true)
		{
			synchronized (konto)
			{
				if (interrupted())
				{
					System.out.println(name + " fertig " + zaehler);
					break;
				}
				zaehler++;

				konto.einzahlen(1000);
				konto.abheben(1000);
			}
		}
	}

}
