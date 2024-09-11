package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadingDataFromPDFFile 
{

	public static void main(String[] args) throws Throwable 
	{
		File fis = new File("./src/test/resources/JSV Cover Letter.pdf shwetha May 1st  (1).pdf");
	     PDDocument doc = PDDocument.load(fis);
	     
	    int pagescount = doc.getNumberOfPages();
	    System.out.println(pagescount);
	    
	    PDFTextStripper pdfData = new PDFTextStripper();
	    String read = pdfData.getText(doc);
	   // System.out.println(read);
	    
	    pdfData.setStartPage(2);
	    //pdfData.setEndPage(2);
	    //pdfData.getText(doc);
	   String read1 = pdfData.getText(doc);
	   System.out.println(read1);
	    
	    
	}

}
