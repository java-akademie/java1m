package ch.jkurs.a05_personenverwaltung;

import ch.jmildner.tools.MyTools;

public class Person
{
	private int id;
	private String name;
	private String addr;
	private String teln;


	public Person()
	{
		id = MyTools.getInteger("     ID      > ");
		name = MyTools.getString("     Name    > ");
		addr = MyTools.getString("     Adresse > ");
		teln = MyTools.getString("     Telefon > ");
	}


	public Person(int id, String name, String addr, String teln)
	{
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.teln = teln;
	}


	public Person(String str)
	{
		String[] arr = str.split("::");

		id = Integer.parseInt(arr[0]);
		name = arr[1];
		addr = arr[2];
		teln = arr[3];
	}


	@Override
	public boolean equals(Object that)
	{
		if (!(that instanceof Person))
		{
			return false;
		}

		if (this.id == ((Person) that).id)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public int getId()
	{
		return id;
	}


	public String show()
	{
		System.out.println("     ID     : " + id);
		System.out.println("     Name   : " + name);
		System.out.println("     Adresse: " + addr);
		System.out.println("     Telefon: " + teln);
		System.out.println();

		StringBuffer sb = new StringBuffer();

		sb.append("     ID     : " + id + "\n");
		sb.append("     Name   : " + name + "\n");
		sb.append("     Adresse: " + addr + "\n");
		sb.append("     Telefon: " + teln + "\n");
		sb.append("\n");

		return sb.toString();
	}


	@Override
	public String toString()
	{
		return id + "::" + name + "::" + addr + "::" + teln;
	}
}
