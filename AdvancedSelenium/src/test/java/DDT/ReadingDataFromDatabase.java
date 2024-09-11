package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadingDataFromDatabase 
{

	public static void main(String[] args) throws Throwable 
	{
		Driver driverref= new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancedselenium", "root", "root");
		Statement stmt = conn.createStatement();
		String query = "select * from selenium";
		ResultSet result = stmt.executeQuery(query);
		
		while (result.next())
		{
			System.out.println(result.getInt(1)+ "\t"+ result.getString(2)+ "\t"+ result.getString(3)+ "\t"+result.getString(4));
		}
		conn.close();

	}

}
