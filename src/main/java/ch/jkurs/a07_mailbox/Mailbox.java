package ch.jkurs.a07_mailbox;

public class Mailbox
{
	private String message = "";
	private boolean messageVorhanden;


	public String getMessage()
	{
		messageVorhanden = false;
		return message;
	}


	public boolean isMessageVorhanden()
	{
		return messageVorhanden;
	}


	public void setMessage(String message)
	{
		this.message = message;
		messageVorhanden = true;
	}

}
