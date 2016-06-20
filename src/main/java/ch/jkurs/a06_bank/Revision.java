package ch.jkurs.a06_bank;

public class Revision extends Thread
{
	private Konto konto;

	private long zaehler;
	private long fzaehler;


	public Revision(Konto konto)
	{
		this.konto = konto;
	}


	@Override
	public void run()
	{
		while (true)
		{
			synchronized (konto)
			{
				int saldo = konto.getSaldo();

				if (saldo != 0)
				{
					fzaehler++;
					System.out.println("saldo nicht null: " + saldo
							+ " zaehler: " + zaehler);
					konto.setSaldo(0);
				}
				else
				{
					zaehler++;
				}


				if (interrupted())
				{
					System.out.println("Revision" + " fehler: "
							+ fzaehler + " fertig " + zaehler);
					break;
				}
			}
		}
	}
}
