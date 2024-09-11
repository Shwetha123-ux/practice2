package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
	public String getExcelData(String SheetName, int rowNum, int cellNum ) throws Throwable
	{
		
		/**
		 * This method is used to get 
		 * @param 
		 * @author Shwetha M
		 */
		FileInputStream fis = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		 Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		
		Cell cell = row.getCell(cellNum);
		String ExcelData = cell.getStringCellValue();
		//System.out.println(ExcelData);
		return ExcelData;	 
	}
	public String getExcelDataUsingDataFormatter(String sheetName, int rowNum, int cellNUm) throws Throwable
	{
		FileInputStream fis11 = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
		Workbook book1 = WorkbookFactory.create(fis11);
		Sheet sheet1 = book1.getSheet(sheetName);

		// To get Campaign name
		Row row1 = sheet1.getRow(rowNum);
		Cell cell1 = row1.getCell(cellNUm);
		
		DataFormatter dataFormat = new DataFormatter();
		String ExcelData1 = dataFormat.formatCellValue(cell1);
		//System.out.println(ExcelData1);
		return ExcelData1;	
	}
	
	public Object[][] getDataProviderData(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum()+1;
		System.out.println(rowcount);
		int cellcount = sheet.getRow(0).getLastCellNum();
		System.out.println(cellcount);
		
		Object[][] objArr = new Object[rowcount][cellcount];
		
		for(int i=0; i<rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return objArr;
		
	}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
}
