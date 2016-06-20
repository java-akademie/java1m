package ch.jmildner.java1;

import ch.jmildner.java1.App;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase
{

	public AppTest(String testName)
	{
		super(testName);
	}


	public static Test suite()
	{
		return new TestSuite(AppTest.class);
	}


	public void testApp()
	{
		assertTrue(true);
		App.main(new String[] {});
	}
}
