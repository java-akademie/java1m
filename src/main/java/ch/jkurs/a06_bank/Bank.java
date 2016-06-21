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

		revision.start();
		cs.start();
		db.start();
		ubs.start();

		try
		{
			Thread.sleep(2 * 500);
		}
		catch (InterruptedException e)
		{
		}
		
		System.out.println("\nFilialen werden geschlossen\n");

		cs.interrupt();
		db.interrupt();
		ubs.interrupt();
		revision.interrupt();

		cs.join();
		db.join();
		ubs.join();
		revision.join();

		cs.protokoll();
		db.protokoll();
		ubs.protokoll();
		revision.protokoll();
		
		System.out.println("\nBank geschlossen");
	}

}
