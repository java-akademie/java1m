package ch.java_akademie.sonstiges;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class WorteZaehlen
{
	static TreeSet<String> s = new TreeSet<String>();
	static int zaehler1 = 0, zaehler2 = 0;


	private static void ausgeben(String next)
	{
		if (next.endsWith(".") || next.endsWith(",")
				|| next.endsWith("!") || next.endsWith(";"))
		{
			next = next.substring(0, next.length() - 1);
		}
		next = next.toLowerCase();
		// System.out.println(next);
		if (s.add(next))
			zaehler1++;
		zaehler2++;
	}


	public static void main(String[] args) throws FileNotFoundException
	{
		FileInputStream fis = new FileInputStream("temp/mylog.txt");
		String regex = "\\s+";
		Scanner scanner = new Scanner(fis);
		scanner.useDelimiter(regex);

		while (scanner.hasNext())
		{
			ausgeben(scanner.next());
		}
		scanner.close();

		System.out.println("Size=" + s.size());
		System.out.println(zaehler1);
		System.out.println(zaehler2);
		System.out.println("---------------------------------");
		for (String str : s)
		{
			System.out.println(str);
		}
	}

}
