package ch.jkurs.a06_bank;

public class Bank
{
	public void run() throws InterruptedException
	{
		System.out.println("Bank geoeffnet\n");

		Konto konto = new Konto();

		Filiale cs = new Filiale("CS", konto);
		Filiale db = new Filiale("DB", konto);
		Filiale ubs = new Filiale("UBS", konto);

		Revision revision = new Revision(konto);

		cs.start();
		db.start();
		ubs.start();
		revision.start();

		try
		{
			Thread.sleep(5 * 1000);
		}
		catch (InterruptedException e)
		{
		}

		cs.interrupt();
		db.interrupt();
		ubs.interrupt();
		revision.interrupt();

		cs.join();
		db.join();
		ubs.join();
		revision.join();

		System.out.println("\nBank geschlossen");
	}

}
