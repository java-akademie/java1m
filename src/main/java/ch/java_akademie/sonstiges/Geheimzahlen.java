package ch.java_akademie.sonstiges;

public class Geheimzahlen
{

	public static void main(String[] args)
	{
		new Geheimzahlen().doit();

	}

	private void doit()
	{
		int mp= 1342;
		
		int gz =8621; // 9492, 5254, 080846
		
		int merkzahl=mp*gz;
		
		for(int i=1; i<=9999; i++)
		{
			double erg=merkzahl/i;
			if(erg*i==merkzahl) System.out.println(merkzahl+" "+i);
		}
	}

}
