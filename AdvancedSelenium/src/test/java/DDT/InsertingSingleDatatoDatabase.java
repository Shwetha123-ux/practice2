package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Driver;

import com.mysql.cj.jdbc.Driver;

public class InsertingSingleDatatoDatabase 
{

	public static void main(String[] args) throws Throwable
	{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancedselenium", "root", "root");
		Statement stmt = conn.createStatement();		//String query = "insert into selenium(first_name, last_name,address) values('bush','hush','hsn')";
		String query = "insert into selenium(first_name, last_name,address)values('bush','hush','hsn')";
		int result = stmt.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("data is added");
		}
		else
		{
			System.out.println("data is not added");
		}
		conn.close();
	}

}
