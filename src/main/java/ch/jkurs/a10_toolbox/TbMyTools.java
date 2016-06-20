package ch.jkurs.a10_toolbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class TbMyTools
{
	public static int getInteger(String prompt)
	{
		while (true)
		{
			try
			{
				return Integer.parseInt(getString(prompt));
			}
			catch (Exception e)
			{
				System.out.print("not an integer .... ");
				System.out.flush();
			}
		}
	}


	public static String getString(String prompt)
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print(prompt);
		System.out.flush();

		try
		{
			return br.readLine();
		}
		catch (IOException e)
		{
			throw new Error(e);
		}

	}


	private TbMyTools()
	{
	}
}
