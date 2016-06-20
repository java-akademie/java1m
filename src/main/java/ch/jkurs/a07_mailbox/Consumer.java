package ch.jkurs.a07_mailbox;


public class Consumer extends Thread
{
	private Mailbox mailbox;
	private int id;


	public Consumer(Mailbox mailbox, int id)
	{
		this.mailbox = mailbox;
		this.id = id;
	}


	private String getMessage()
	{
		String m = "";

		synchronized (mailbox)
		{
			while (!(mailbox.isMessageVorhanden()))
			{
				try
				{
					mailbox.wait();
				}
				catch (InterruptedException e)
				{
					interrupt();
					return " interrupted";
				}
			}

			m = mailbox.getMessage();
			mailbox.notifyAll();
		}

		return m;
	}


	@Override
	public void run()
	{
		while (true)
		{
			if (interrupted())
				break;

			String m = getMessage();
			System.out.println(id + ":" + m);
		}
	}
}
