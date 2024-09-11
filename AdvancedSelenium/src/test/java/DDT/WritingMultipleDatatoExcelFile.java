package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WritingMultipleDatatoExcelFile
{
 
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet4");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		List<WebElement> allinks = driver.findElements(By.xpath("//a"));
		System.out.println(allinks.size());
		
		for(int i=0;i<allinks.size();i++)
		{
		
		Row row = sheet.createRow(i);
		Cell cell = row.createCell(0);
		cell.setCellValue(allinks.get(i).getAttribute("href"));
		}
		
		
		FileOutputStream fos = new FileOutputStream("E:\\AdvancedSelenium\\TestData8.xlsx");
		book.write(fos);
		book.close();
		System.out.println("data written..");
		
	}

}
