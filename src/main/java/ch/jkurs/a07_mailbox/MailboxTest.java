package ch.jkurs.a07_mailbox;

public class MailboxTest
{
	static final int maxConsumer = 100;
	static final int maxProducer = 100;
	static final int maxMessages = 500;


	public static void main(String[] args) throws InterruptedException
	{
		Mailbox mailbox = new Mailbox();

		Consumer[] consumer = new Consumer[maxConsumer];
		Producer[] producer = new Producer[maxProducer];

		// Erzeuge die Consumer
		for (int i = 0; i < consumer.length; i++)
		{
			consumer[i] = new Consumer(mailbox, i + 1);
		}

		// Erzeuge die Producer
		// jeder schreibt eine bestimmte Anzahl von Messages

		for (int i = 0; i < producer.length; i++)
		{
			producer[i] = new Producer(mailbox, i + 1, maxMessages);
		}

		// Starte die Consumer
		for (Thread th : consumer)
		{
			th.start();
		}

		// Starte die Producer
		for (Thread th : producer)
		{
			th.start();
		}

		// Warte auf die Producer
		for (Thread th : producer)
		{
			th.join();
		}

		// Stoppe die Consumer
		for (Thread th : consumer)
		{
			th.interrupt();
		}

		// Gib den Consumern Zeit die letzte Meldung abzusetzen
		Thread.sleep(500);

		System.out.println("Programmende .....................");
	}
}
