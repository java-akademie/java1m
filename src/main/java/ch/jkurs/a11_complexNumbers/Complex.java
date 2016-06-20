package ch.jkurs.a11_complexNumbers;

import java.util.Formatter;

public class Complex
{
	private double x, y;
	private double r, f; // f als radian


	private Complex(double x, double y, double r, double f)
	{
		//
		// wenn einer der Werte im Intervall ]-prec,+prec[ liegt, dann wird der Wert auf 0 gesetzt
		// .........+..........0..........+......
		// .....-0.00001.......0.......+0.00001
		// .........]000000000000000000000[
		//

		this.x = prec(x);
		this.y = prec(y);
		this.r = prec(r);
		this.f = prec(f % (2 * Math.PI));
	}


	public double getX()
	{
		return x;
	}


	public double getY()
	{
		return y;
	}


	public double getR()
	{
		return r;
	}


	public double getF()
	{
		return f;
	}


	public void show()
	{
		System.out.println(this);
	}


	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		Formatter fo = new Formatter(sb);
		fo.format("(%8.3f   + %8.3f i)    <=>    (%8.3f < %8.3f)", x, y, r, (f * (180 / Math.PI)));
		fo.close();
		return sb.toString();
	}


	public static Complex createKartesisch(double x, double y)
	{
		double r= Math.pow((x * x) + (y * y), 0.5);
		double f=winkel(x,y);
		
		return new Complex(x, y, r, f);
	}


	public static Complex createPolar(double radius, double deg)
	{
		deg = deg % 360;

		if (deg < 0)
			deg = 360 + deg;

		double f = radian(deg);

		double x = radius * Math.cos(f);
		double y = radius * Math.sin(f);

		Complex c = new Complex(x, y, radius, f);

		return c;
	}


	static Complex add(Complex a, Complex b)
	{
		return Complex.createKartesisch(a.getX() + b.getX(), a.getY()
				+ b.getY());
	}


	static Complex sub(Complex a, Complex b)
	{
		return Complex.createKartesisch(a.getX() - b.getX(), a.getY()
				- b.getY());
	}


	static Complex mult(Complex a, Complex b)
	{
		return Complex.createPolar(a.getR() * b.getR(),
				a.getF() + b.getF());
	}


	static Complex div(Complex a, Complex b)
	{
		return Complex.createPolar(a.getR() / b.getR(),
				a.getF() - b.getF());
	}


	public static double radian(double deg)
	{
		deg = prec(deg);

		deg = deg % 360;

		if (deg < 0)
			deg = 360 + deg;


		double rad = Math.PI / 180.0 * deg;

		return rad;
	}


	static double winkel(double x, double y)
	{
		x = prec(x);
		y = prec(y);


		/**
		 * wenn y==0 ist, ist der Winkel 0 oder 180
		 */
		if (y == 0.0)
		{
			if (x >= 0.0)
				return 0; // 0°
			else
				return Math.PI; // 90°
		}


		/**
		 * wenn x==0 ist, ist der Winkel 90 oder 270
		 */
		if (x == 0.0)
		{
			if (y >= 0.0)
				return Math.PI / 2; // 90°
			else
				return Math.PI / 2 * 3;// 270°
		}

		// ///////////////////////////////

		double winkel = Math.atan(y / x);

		if (x >= 0.0)
		{
			// I. oder IV. Quadrant
			if (y >= 0.0)
			{
				// I. Quadrant
				return winkel;
			}
			else
			{
				// IV. Quadrant
				return winkel + 2 * Math.PI;
			}
		}
		else
		{
			// II. oder III. Quadrant
			return winkel + Math.PI;
		}
	}


	private static double prec(double w)
	{
		double prec = 0.000000001;

		if (w < prec && w > -prec)
			return 0.0;
		else
			return w;
	}


}
