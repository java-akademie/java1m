package ch.jkurs.a07_nachrichten;

public interface NachrichtenQuelle
{
	public void addAbonnent(NachrichtenEmpfaenger empf);
	public void neueNachricht(String nachricht);
}
