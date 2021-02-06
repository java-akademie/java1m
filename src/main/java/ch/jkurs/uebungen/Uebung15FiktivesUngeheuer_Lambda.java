package ch.jkurs.uebungen;

import ch.jmildner.tools.MyTools;

public class Uebung15FiktivesUngeheuer_Lambda
{
	//
	// gibLaut verlangt einen Brueller (das Interface Uebung12Brueller)
	//
	private static void gibLaut(Uebung12Brueller brueller)
	{
		System.out.println();
		System.out.println(brueller);
		brueller.bruellen();
	}



	private static void test1()
	{
		MyTools.h2("test1", 3);
		Uebung12Brueller brueller = () -> System.out.println("quiiiiiiiiiuuuuuuaaaaaaahhhhhhhh");
		brueller.bruellen();
	}


	private static void test2()
	{
		MyTools.h2("test2", 3);
		/**
		 * Lambda
		 */
		Uebung12Brueller gruseligesUngeheuer2 = //
				( //
				/**
				 * Parameterliste der einzigen Methode in
				 * Uebung12Brueller - bruellen() hat keine Parameter
				 */
				) //
				-> //
				{
					/**
					 * Implementierung
					 */
					System.out.println(
							"ich bin das gruseliges Ungeheuer2");
					System.out.println("laaaaaaambdaaaaaaahhhhhhhh");
				};
		gibLaut(gruseligesUngeheuer2);
		gibLaut(gruseligesUngeheuer2);

		gibLaut(() -> {
			System.out.println(
					"ich bin die 1. uebergebene Implementierung");
			System.out.println("uaaaaaahhhhhhhhh");
		});

		gibLaut(() -> {
			System.out.println(
					"ich bin die 2. uebergebene Implementierung");
			System.out.println("uaaaaaahhhhhhhhh");
		});

		gibLaut(() -> {
			System.out.println(
					"ich bin die 3. uebergebene Implementierung");
			System.out.println("uaaaaaahhhhhhhhh");
		});
	}


	public static void main(String[] args)
	{
		test1();
		test2();
	}
}


