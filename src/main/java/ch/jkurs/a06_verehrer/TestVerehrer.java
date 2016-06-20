package ch.jkurs.a06_verehrer;


public class TestVerehrer
{
	public static void main(String[] args)
	{
		Dame d = new Dame();
		Herr h = new Herr();
		

		d.addVerehrer(h);
		d.doIt();
	}
}
