package ch.java_akademie.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfSchreiben
{
	public static final String PDF = "temp/document.pdf";


	public void createPdf(String filename)
			throws DocumentException, IOException
	{
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(filename));
		document.open();
		PdfContentByte cb = writer.getDirectContent();
		BaseFont bf = BaseFont.createFont();
		
		
		for (int i = 1; i <= 10; i++)
			document.add(new Chunk("  xxx " + i));

		// setImage(cb, "temp/vanessa.jpg", 40/2);
		cb.beginText();
		cb.setFontAndSize(bf, 12);
		// cb.moveText(20, 105);
		cb.moveText(20, 750);
		cb.showText(
				"Falsches Ü̈ben von Xylophonmusik quält jeden grösseren Zwerg.");
		System.out.println(cb.getCharacterSpacing());
		cb.setCharacterSpacing(2);
		cb.setWordSpacing(12);
		cb.moveText(120, -16);
		cb.newlineShowText("Erst recht auch jeden kleineren.");
		cb.setCharacterSpacing(0);
		cb.setWordSpacing(0);
		cb.moveText(-60, -32);
		cb.newlineShowText(
				"Falsches Ü̈ben von Xylophonmusik quält jeden grösseren Zwerg.");
		cb.moveText(0, -16);
		cb.newlineShowText(
				"Falsches Ü̈ben von Xylophonmusik quält jeden grösseren Zwerg.");
		cb.moveText(0, -16);
		cb.newlineShowText(
				"Falsches Ü̈ben von Xylophonmusik quält jeden grösseren Zwerg.");


		Image vanessa = Image.getInstance("temp/vanessa.jpg");
		vanessa.scalePercent(25f);
		vanessa.setAbsolutePosition(100f, 200f);
		document.add(vanessa);


		cb.moveText(0, -200);
		setImage(cb, "temp/vanessa.jpg", 10f);

		cb.endText();
		document.close();
	}


	private void setImage(PdfContentByte cb, String imgPath,
			float scalePercent)
			throws MalformedURLException, IOException, DocumentException
	{
		Image img = Image.getInstance(imgPath);
		img.scalePercent(scalePercent);
		img.setAbsolutePosition(cb.getXTLM(), cb.getYTLM());
		cb.addImage(img);
	}


	private void printMeasures()
	{
		System.out.println("A4-Ma\u00DFe: " + PageSize.A4.getWidth()
				+ "pt x " + PageSize.A4.getHeight() + "pt - "
				+ (PageSize.A4.getWidth() * 0.3527) + "mm x "
				+ (PageSize.A4.getHeight() * 0.3527) + "mm");
	}


	public static void main(String[] args)
			throws DocumentException, IOException
	{
		PdfSchreiben ps = new PdfSchreiben();
		ps.createPdf(PDF);
		ps.printMeasures();
		System.out.println("done");
	}
}

