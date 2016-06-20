package ch.jkurs.a07_mailbox;


public class Producer extends Thread
{
	private Mailbox mailbox;
	private int id;
	private int max;


	public Producer(Mailbox mailbox, int id, int max)
	{
		this.mailbox = mailbox;
		this.id = id;
		this.max = max;
	}


	@Override
	public void run()
	{
		for (int i = 1; i <= max; i++)
		{
			setMessage("msg-" + (id * 100000 + i));
		}
	}


	private void setMessage(String m)
	{
		synchronized (mailbox)
		{
			while (mailbox.isMessageVorhanden())
			{
				try
				{
					mailbox.wait();
				}
				catch (InterruptedException e)
				{
					interrupt();
				}
			}

			mailbox.setMessage(m);
			mailbox.notifyAll();
		}
	}
}
