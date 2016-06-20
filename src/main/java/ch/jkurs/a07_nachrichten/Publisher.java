package ch.jkurs.a07_nachrichten;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements NachrichtenQuelle
{
	private String name;
	private List<NachrichtenEmpfaenger> empfaenger = new ArrayList<NachrichtenEmpfaenger>();


	public Publisher(String name)
	{
		this.name = name;
	}


	@Override
	public void addAbonnent(NachrichtenEmpfaenger empf)
	{
		empfaenger.add(empf);
	}


	@Override
	public void neueNachricht(String nachricht)
	{
		for (NachrichtenEmpfaenger e : empfaenger)
		{
			e.empfangeNachricht(name + " " + nachricht);
		}
	}
}
