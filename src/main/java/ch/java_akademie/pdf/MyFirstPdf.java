package ch.java_akademie.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class MyFirstPdf
{
	public static void main(String[] args)
			throws FileNotFoundException, DocumentException
	{
		String outputFile = "temp/fritz.pdf";
		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, new FileOutputStream(outputFile));

		doc.open();

		doc.addAuthor("Johann Mildner Basel");
		doc.addHeader("header1", "header2");
		doc.addTitle("titel");
		doc.addSubject("subject1");
		doc.add(new Paragraph("text des ersten paragraphen"));
		doc.addSubject("subject2");
		doc.add(new Paragraph("text des zweiten paragraphen"));
		doc.add(new Paragraph(""));
		doc.add(new Paragraph("text des dritten paragraphen"));
		doc.add(new Paragraph(""));
		doc.add(new Paragraph("text des vierten paragraphen"));


		doc.close();
	}


}
