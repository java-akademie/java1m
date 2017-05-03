package ch.jkurs.uebungen;

public class Uebung12xTestGruseligesUngeheuer
{
	public static void main(String[] args)
	{
		/**
		 * anonyme innere Klasse
		 */
		Uebung12Brueller gruseligesUngeheuer1 = new Uebung12Brueller()
		{
			@Override
			public void bruellen()
			{
				System.out.println("ich bin das gruseliges Ungeheuer1");
				System.out.println("uuuuuaaaaaahhhhhhhhhhhhhhh");
			}
		};
		gibLaut(gruseligesUngeheuer1);
		gibLaut(gruseligesUngeheuer1);

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


	private static void gibLaut(Uebung12Brueller b)
	{
		System.out.println();
		System.out.println(b);
		b.bruellen();
	}
}
