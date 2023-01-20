package Tester;

import java.sql.*;
import static Utils.DBUtils.openConnection;

public class TestConnection 
{
	public static void main(String[] args) 
	{
			try(Connection cn = openConnection();
				Statement st = cn.createStatement();
				ResultSet rst = st.executeQuery("select * from my_emp");)
			{
				while (rst.next())
				{
					System.out.printf("Emp id %d, Name %s, Adrss %s, Salary %.1f, Dept id %s, Join Date %s %n",
							rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getString(5),rst.getString(6));
				}
			}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
