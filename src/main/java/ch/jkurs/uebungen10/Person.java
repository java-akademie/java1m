package ch.jkurs.uebungen10;

import ch.java_akademie.tools.MyTools;

public class Person
{
	private int id;
	private String name;
	private String addr;


	public Person()
	{
		id = MyTools.getInteger("     ID      > ");
		name = MyTools.getString("     Name    > ");
		addr = MyTools.getString("     Adresse > ");
	}


	public Person(int id, String name, String addr)
	{
		this.id = id;
		this.name = name;
		this.addr = addr;
	}


	public Person(String str)
	{
		String[] arr = str.split("~");

		id = Integer.parseInt(arr[0]);
		name = arr[1];
		addr = arr[2];
	}



	public void show()
	{
		System.out.println("     ID     : " + id);
		System.out.println("     Name   : " + name);
		System.out.println("     Adresse: " + addr);
		System.out.println();
	}


	@Override
	public String toString()
	{
		return id + "~" + name + "~" + addr;
	}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getAddr()
	{
		return addr;
	}


	public void setAddr(String addr)
	{
		this.addr = addr;
	}


}
