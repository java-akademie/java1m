package ch.jkurs.a09_muenzen;

import java.text.SimpleDateFormat;

abstract class Constants
{
	static final int SUM_WEIGHT = 379644;
	static final int SUM_AMOUNT = 22198;

	// static final int SUM_WEIGHT = 200000; // 2 kg
	// static final int SUM_AMOUNT = 20000; // 200 €

	static final SimpleDateFormat DF = new SimpleDateFormat(
			"dd.MM.yyyy HH:mm:ss");


	private Constants()
	{
	}

}
