package ch.jkurs.a07_nachrichten;
public class Subscriber implements NachrichtenEmpfaenger
{
	private String name;
	public Subscriber(String name)
	{
		this.name = name;
	}
	@Override
	public void empfangeNachricht(String nachricht)
	{
		System.out.println("Nachricht an " + name + " : " + nachricht);
	}
}
