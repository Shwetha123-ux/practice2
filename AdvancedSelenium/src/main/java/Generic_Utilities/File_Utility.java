package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility 
{
	/**
	 * This method is used to 
	 * @author Shwetha M
	 * @throws FileNotFoundException 
	 */
	
	public String gettKeyAndValueData(String Key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtigerlogins.properties");
		Properties pro = new Properties();
		pro.load(fis);
		return pro.getProperty(Key);
	}
}
