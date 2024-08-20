package bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
public static Connection myConnection()
{
	    String url = "jdbc:mysql://localhost:3306/miniproject";
	    String username = "root";
	    String password = "11092021";
	    
	   Connection con = null;
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		   con=DriverManager.getConnection(url,username,password);
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	   return con;
}
}
