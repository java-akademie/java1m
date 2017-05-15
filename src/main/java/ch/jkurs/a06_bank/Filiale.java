package ch.jkurs.a06_bank;

public class Filiale extends Thread
{
	private long zaehler;
	private long zaehler2;
	private String name;
	private Konto konto;


	public Filiale(String name, Konto konto)
	{
		this.name = name;
		this.konto = konto;
	}


	public void protokoll()
	{
		System.out.printf("%10s  buchungen %,d  %,d %n", name, zaehler, zaehler2);
	}


	@Override
	public void run()
	{
		while (true)
		{
			if (interrupted())
			{
				break;
			}

			synchronized (konto)
			{
				zaehler++;

				if (zaehler == 10)
				{
					// fehler simulieren
					konto.einzahlen(1);
					konto.abheben(2);
				}
				else
				{
					konto.einzahlen(1000);
					konto.abheben(1000);
					if (konto.getSaldo() == 0)
						;
					else
					{
						zaehler2++;
						System.out.println(konto.getSaldo() + name);
					}
				}
			}
		}
	}

}
