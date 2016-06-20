package ch.jkurs.a08_split;

import java.io.FileInputStream;
import java.io.FileOutputStream;



public class Split2
{
	static String funktion;
	static String quelle;
	static String target;
	static String extention;
	static int laenge;


	public static void main(String[] args) throws Exception
	{
		if (args.length != 5)
		{
			System.out.println("Aufruf: java ch.jmildner.split.Split ");
			System.out
					.println("funktion t=teilen oder z=zusammenfuegen ");
			System.out.println("quelle  target   extention ");
			System.out
					.println("splitLaenge bei teilen / 0 bei zusammenfuegen");
			System.exit(1);
		}

		funktion = args[0];
		quelle = args[1];
		target = args[2];
		extention = args[3];
		laenge = Integer.parseInt(args[4]);

		System.out.println("funktion    = " + funktion);
		System.out.println("quelle      = " + quelle);
		System.out.println("target      = " + target);
		System.out.println("extention   = " + extention);
		System.out.println("splitLaenge = " + laenge);

		if (funktion.equals("t"))
		{
			teilen();
		}
		if (funktion.equals("z"))
		{
			zusammenfuegen();
		}
	}


	public static void teilen() throws Exception
	{
		int fz = 0, len = 0;

		FileInputStream fis = new FileInputStream(quelle + "."
				+ extention);
		FileOutputStream fos = null;
		byte[] buff = new byte[laenge];

		while ((len = fis.read(buff)) > 0)
		{
			fos = new FileOutputStream(target + ++fz + "." + extention);
			fos.write(buff, 0, len);
		}
		fis.close();
		fos.close();
	}


	public static void zusammenfuegen() throws Exception
	{
		int len = 0, fz = 0;

		FileOutputStream fos = new FileOutputStream(target + "."
				+ extention);
		FileInputStream fis = null;
		byte[] buff = new byte[2000000];

		while (true)
		{
			try
			{
				fis = new FileInputStream(quelle + ++fz + "."
						+ extention);
				while ((len = fis.read(buff)) > 0)
				{
					fos.write(buff, 0, len);
				}
			}
			catch (Exception e)
			{
				break;
			}
		}
		fos.close();
	}
}
