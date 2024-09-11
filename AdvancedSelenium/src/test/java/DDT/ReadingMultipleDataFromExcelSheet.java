package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingMultipleDataFromExcelSheet 
{

	public static void main(String[] args) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet2");
		
		int rownum = sheet.getLastRowNum();
		System.out.println(rownum);
		
		for (int i=0; i<=rownum; i++)
		{
			Row row = sheet.getRow(i);
			
			for (int j=0;j<row.getLastCellNum();j++)
			{
			 System.out.println(row.getLastCellNum()); //doubt - does the cell no in Excel starts from 0 or 1 ?
			 Cell cell = row.getCell(j);
			 String links = cell.getStringCellValue();
			 System.out.println(links);
			 
			}
		}
	}

}
