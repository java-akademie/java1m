package ch.java_akademie.sonstiges;
import java.util.Arrays;

public class EinTest
{

	static int l;
	static int[] in;
	static int[] out;


	public static void main(String[] args)
	{
		init();


		test1();
		test2(in.length);
	}


	private static void init()
	{
		l = 3;
		in = new int[l];
		out = new int[l];
		for (int i = 0; i < l; i++)
		{
			in[i] = (int) (Math.random() * 10 + 2);
		}

	}


	private static void test2(int l)
	{
		int[][] x = new int[l][l];
		
		for (int i = 0; i < l; i++)
		{
			x[i] = in;
			x[i][i] = 1;
		}

	}


	private static void test1()
	{
		for (int i = 0; i < in.length; i++)
		{
			out[i] = get(i);
		}

		System.out.println(Arrays.toString(in));
		System.out.println(Arrays.toString(out));
	}


	private static int get(int i)
	{
		int f = 1;
		for (int j = 0; j < in.length; j++)
		{
			if (j != i)
				f *= in[j];
		}
		return f;
	}

}
