package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils 
{
	private static Connection cn ;
	
	public static void openConnection() throws SQLException
	{
		String url =  "jdbc:mysql://localhost:3306/iacsd?useSSL=false&allowPublicKeyRetrieval=true";
		cn = DriverManager.getConnection(url,"root","welcome@123");
	}
	
	public static void closeConnection() throws SQLException
	{
		if (cn != null) 
		{
			cn.close();
		}
	}
	
	public static Connection getConnect()
	{
		return cn;
	}
}
