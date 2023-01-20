package Tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import DAO.EmployeeDaoImple;

public class TestLayeredApp 
{
	public static void main(String[] args)
	{
		try(Scanner sc = new Scanner(System.in);)
		{
			EmployeeDaoImple dao = new EmployeeDaoImple();
			System.out.println("Enter the deptid & joindate : ");
			dao.getEmpDetailsByDeptAndDate(sc.next(),Date.valueOf(sc.next())).forEach(System.out::println);
			dao.cleanup();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
