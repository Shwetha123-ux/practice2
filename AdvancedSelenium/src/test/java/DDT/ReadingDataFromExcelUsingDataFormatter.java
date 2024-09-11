package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcelUsingDataFormatter 
{

	public static void main(String[] args) throws Throwable 
	{
		//STEP1: Path Representation
				FileInputStream fis = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
				
				//STEP2: Keeping the excel file in read mode
				Workbook book = WorkbookFactory.create(fis);
				
				//STEP3:Get the control to Sheet1
				Sheet sheet = book.getSheet("Sheet1");
				
				//STEP4: Get the control to the Row
				Row row = sheet.getRow(0);
				
				//STEP5: Get the control to the cell
				Cell cell = row.getCell(0);
				
				DataFormatter dataformat = new DataFormatter();
				String Exceldata = dataformat.formatCellValue(cell);
				System.out.println(Exceldata);

	}

}
