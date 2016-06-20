package ch.jkurs.a10_toolbox;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public final class TbTextFile
{
	private BufferedReader br;
	private PrintWriter pw;


	public TbTextFile(String fname, char mode) throws Exception
	{
		if (mode == 'r')
			this.br = openInput(fname);
		else
			if (mode == 'w')
				this.pw = openOutput(fname);
			else
				throw new Exception("mode falsch " + mode);
	}


	public void close() throws Exception
	{
		if (br != null)
		{
			br.close();
			br = null;
		}
		if (pw != null)
		{
			pw.close();
			pw = null;
		}
	}


	private BufferedReader openInput(String fname) throws Exception
	{
		return new BufferedReader(new FileReader(fname));
	}


	private PrintWriter openOutput(String fname) throws Exception
	{
		return new PrintWriter(
				new BufferedWriter(new FileWriter(fname)));
	}


	public void printLine(String line)
	{
		pw.println(line);
		pw.flush();
	}


	public String readLine() throws Exception
	{
		String zeile = null;
		zeile = br.readLine();
		return zeile;
	}
}
