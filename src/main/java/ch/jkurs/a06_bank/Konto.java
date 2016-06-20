package ch.jkurs.a06_bank;

public class Konto
{
	private int saldo;


	public void abheben(int b)
	{
		saldo -= b;
	}


	public void einzahlen(int b)
	{
		saldo += b;
	}


	public int getSaldo()
	{
		return saldo;
	}


	public void setSaldo(int b)
	{
		saldo = b;
	}
}
