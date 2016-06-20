package ch.jkurs.a10_toolbox;

public class TestToolbox
{

	public static void main(String[] args) throws Exception
	{
		test1();
		test2();
	}


	private static void test1() throws Exception
	{
		TbTextFile tf;
		tf = new TbTextFile("xxx.txt", 'w');
		tf.printLine("xxxxxxx");
		tf.printLine("xxxxxxx");
		tf.printLine("xxxxxxx");
		tf.printLine("xxxxxxx");
		tf.printLine("xxxxxxx");
		tf.printLine("xxxxxxx");
		tf.close();

		tf = new TbTextFile("xxx.txt", 'r');
		String s = tf.readLine();
		while (s != null)
		{
			System.out.println(s);
			s = tf.readLine();
		}
		tf.close();
	}


	private static void test2()
	{
		String s = TbMyTools.getString("name > ");
		System.out.println(s);
		int i = TbMyTools.getInteger("int  > ");
		System.out.println(i);
	}

}
