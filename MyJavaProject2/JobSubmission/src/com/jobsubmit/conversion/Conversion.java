package com.jobsubmit.conversion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.jsoup.Jsoup;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

public class Conversion {

	/*
	 * This method takes four parameters as input which are replaced in the
	 * template file. used the apache Velocity Engine to replace the parameters
	 * in the template file.
	 */
	public String generateFile(String positionName, String companyName, String sourceUrl, String hrName) {
		// creating Velocity Engine object
		VelocityEngine ve = new VelocityEngine();
		// initialize the ve object
		Properties p = new Properties();

		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		ve.init(p);
		// get the template
		/*
		 * Set the properties file for the velocity engine, where to search the
		 * template file. if given as class folder then place the file in the
		 * src root directory of the project and relate the path in the below
		 * line of code.
		 */
		//Template template1 = ve.getTemplate("templates/newletter.vm");
		Template template = ve.getTemplate("letter.vm");
		
		//added a simple date format to get the current date
		DateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy");
		Date currentDate = new Date();
		System.out.println(dateFormat.format(currentDate));
		
		// creating a context and adding data into the context.
		VelocityContext context = new VelocityContext();
		context.put("currentDate", dateFormat.format(currentDate));
		context.put("positionName", positionName);
		context.put("companyName", companyName);
		context.put("sourceUrl", sourceUrl);
		context.put("hrName", hrName);

		StringWriter writer = new StringWriter();
		template.merge(context, writer);
		return writer.toString();
	}

	/*
	 * This method takes 2 parameters, the text to be generated as pdf and the
	 * path to save the generated file. Using the IText API , and HtmlWorker
	 * class to generate the pdf from the html text.
	 * 
	 */
	public void generatePdf(String text, String path) {
		Document doc = new Document();
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(doc, new FileOutputStream(path));
			doc.open();
			HTMLWorker htmlWorker = new HTMLWorker(doc);
			try {
				htmlWorker.parse(new StringReader(text));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// jsoup to used to remove the html tags from a String..in this case
			// is not desired.
			// doc.add(new Paragraph(Jsoup.parse(text).text()));
			finally {
				doc.close();
				pdfWriter.close();
			}
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
