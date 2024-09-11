package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingSingleDataToExcelFile
{

	public static void main(String[] args) throws Throwable 
	{
		
		FileInputStream fis = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet3");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(1);
		cell.setCellValue("Ammaaaaaa");
		
		FileOutputStream fos = new FileOutputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
		book.write(fos);
		book.close();
		System.out.println("data written..");
		
	}

}
