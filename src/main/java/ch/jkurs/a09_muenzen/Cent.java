package ch.jkurs.a09_muenzen;

/**
 * 
 * @author andree grosse
 * 
 */
class Cent
{

	private int amount, weight, max;
	
	static final Cent ONE = new Cent(1, 230);
	static final Cent TWO = new Cent(2, 306);
	static final Cent FIVE = new Cent(5, 392);
	static final Cent TEN = new Cent(10, 410);
	static final Cent FIFTY = new Cent(50, 780);
	static final Cent HUNDERT = new Cent(100, 750);


	private Cent(int amount, int weight)
	{
		this.amount = amount;
		this.weight = weight;
		
		this.max = Math.min(Constants.SUM_AMOUNT / amount,
				Constants.SUM_WEIGHT / weight);
	}


	int getAmount()
	{
		return amount;
	}


	int getMaxCount()
	{
		return max;
	}


	int getMaxCount(int sumAmt)
	{
		return Math.min(max,
				(Constants.SUM_AMOUNT - sumAmt) / getAmount());
	}


	int getWeight()
	{
		return weight;
	}
}
