package ch.jkurs.a09_muenzen;

import java.util.Date;


class Calculator
{

	private static int count = 0;
	private static int sumAmt = 0;
	private static int sumWeight = 0;
	static int li, lj, lk, ll, lm, ln;



	private static int add(int i, int j, int k, int l, int m, int n)
	{
		sumAmt = getAmt(i, j, k, l, m, n);

		sumWeight = getWeight(i, j, k, l, m, n);



		if (sumAmt == Constants.SUM_AMOUNT
				&& sumWeight == Constants.SUM_WEIGHT)
		{
			li = i;
			lj = j;
			lk = k;
			ll = l;
			lm = m;
			ln = n;
			
			count++;
			if (count % 10000 == 1)
			{
				out(li, lj, lk, ll, lm, ln);
			}
		}


		return sumAmt;
	}


	private static int getAmt(int i, int j, int k, int l, int m, int n)
	{
		return i * Cent.HUNDERT.getAmount() + j * Cent.FIFTY.getAmount()
				+ k * Cent.TEN.getAmount() + l * Cent.FIVE.getAmount()
				+ m * Cent.TWO.getAmount() + n * Cent.ONE.getAmount();
	}


	private static int getWeight(int i, int j, int k, int l, int m,
			int n)
	{
		return i * Cent.HUNDERT.getWeight() + j * Cent.FIFTY.getWeight()
				+ k * Cent.TEN.getWeight() + l * Cent.FIVE.getWeight()
				+ m * Cent.TWO.getWeight() + n * Cent.ONE.getWeight();
	}


	private static boolean isOverflow()
	{
		return sumAmt > Constants.SUM_AMOUNT
				|| sumWeight > Constants.SUM_WEIGHT;
	}


	private static boolean isUnderflow()
	{
		return sumAmt < Constants.SUM_AMOUNT;
	}


	private static void out(int i, int j, int k, int l, int m, int n)
	{
		String zeile = "%s --> %,7d. "
				+ "Loesung: 1€=%3d, 50ct=%3d, 10ct=%3d, 5ct=%3d, 2ct=%3d, 1ct=%3d. "
				+ "Gewicht=%d, Wert=%d";

		String loesungsZeile = String.format(zeile,
				Constants.DF.format(new Date()), count, i, j, k, l, m,
				n,
				(i * Cent.HUNDERT.getWeight()
						+ j * Cent.FIFTY.getWeight()
						+ k * Cent.TEN.getWeight()
						+ l * Cent.FIVE.getWeight()
						+ m * Cent.TWO.getWeight()
						+ n * Cent.ONE.getWeight()),
				(i * Cent.HUNDERT.getAmount()
						+ j * Cent.FIFTY.getAmount()
						+ k * Cent.TEN.getAmount()
						+ l * Cent.FIVE.getAmount()
						+ m * Cent.TWO.getAmount()
						+ n * Cent.ONE.getAmount()));

		System.out.println(loesungsZeile);
	}


	void calculate()
	{
		for (int i = Cent.HUNDERT.getMaxCount(sumAmt); i >= 0; i--)
		{
			sumAmt = add(i, 0, 0, 0, 0, 0);

			if (isOverflow())
				break;

			for (int j = Cent.FIFTY.getMaxCount(sumAmt); j >= 0; j--)
			{
				sumAmt = add(i, j, 0, 0, 0, 0);

				if (isOverflow())
					break;

				for (int k = Cent.TEN.getMaxCount(sumAmt); k >= 0; k--)
				{
					sumAmt = add(i, j, k, 0, 0, 0);

					if (isOverflow())
						break;

					for (int l = Cent.FIVE
							.getMaxCount(sumAmt); l >= 0; l--)
					{
						sumAmt = add(i, j, k, l, 0, 0);

						if (isOverflow())
							break;

						for (int m = Cent.TWO
								.getMaxCount(sumAmt); m >= 0; m--)
						{
							sumAmt = add(i, j, k, l, m, 0);

							if (isOverflow())
								break;

							for (int n = Cent.ONE
									.getMaxCount(sumAmt); n >= 0; n--)
							{
								sumAmt = add(i, j, k, l, m, n);

								if (isUnderflow())
									break;
							}
						}
					}
				}
			}
		}
	}


	int getSolutions()
	{
		
		out(li, lj, lk, ll, lm, ln);
		return count;
	}

}
