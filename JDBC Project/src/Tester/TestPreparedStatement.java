package Tester;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static Utils.DBUtils.openConnection;

public class TestPreparedStatement 
{

	public static void main(String[] args) throws SQLException 
	{
		String query = "select empid,name,salary,join_date from my_emp where deptid = ? and join_date > ? order by salary";
		
		try(Scanner sc = new Scanner(System.in);
				Connection cn = openConnection();
				PreparedStatement pst = cn.prepareStatement(query);)
		{
			System.out.println("Enter deptid n join date (yyyy-mm-dd)");
			
			pst.setString(1, sc.next());
			pst.setDate(2,Date.valueOf(sc.next()));
			try(ResultSet rst = pst.executeQuery()) 
			{
				while (rst.next()) 
				{
					System.out.printf("Emp id %d, Name %s, Salary %.1f, Join Date %s %n"
							,rst.getInt(1),rst.getString(2),rst.getDouble(3),rst.getDate(4));
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
