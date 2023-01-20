package Utils;

import java.sql.*;

public class DBUtils 
{
	public static Connection openConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/iacsd?useSSL=false&allowPublicKeyRetrieval=true";
		return DriverManager.getConnection(url,"root","welcome@123");
	}
}
