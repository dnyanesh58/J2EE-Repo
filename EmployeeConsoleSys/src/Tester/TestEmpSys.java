package Tester;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import DAO.EmployeeDaoImpl;
import POJO.Employee;

import static Utils.DBUtils.*;

public class TestEmpSys {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			openConnection();

			EmployeeDaoImpl empDao = new EmployeeDaoImpl();
			System.out.println("1.Insert Emp Details");
			System.out.println("2.Update Emp Details");
			System.out.println("3.Get All Emp Details");
			System.out.println("4.Get Emp By Dept & join date Details");
			System.out.println("5.Delete Emp Details");
			System.out.println("6.Exit");

			boolean flag = true;
			while (flag) 
			{
				try
				{
					switch (sc.nextInt()) 
					{
					case 1:
						System.out.println("Enter emp details : name,  address,  salary,  deptId,  joinDate(yr-mon-day)");
						System.out.println(empDao.insertEmployee(
								new Employee(sc.next(), sc.next(), sc.nextDouble(), sc.next(), Date.valueOf(sc.next()))));
						break;

					case 2:
						System.out.println("Enter sal incr , new dept n emp id , to udpate specific emp details");
						System.out.println(empDao.updateEmployee(sc.nextDouble(), sc.next(), sc.nextInt()));
						break;
						
					case 3:
						List<Employee> list = empDao.getAllEmployee();
						System.out.println(list);
						/*
						 * for (Employee employee : list) { System.out.println(list); }
						 */
						break;

					case 4:
						System.out.println("Enter dept id n join date (yr-mon-day)");
						empDao.getAllEmployeesByDeptAndDate(sc.next(), Date.valueOf(sc.next()))
								.forEach(System.out::println);
						break;

					case 5:
						System.out.println("Enter emp id to delete emp details");
						System.out.println(empDao.deleteEmployee(sc.nextInt()));
						break;

					case 6:
						flag = false;
						break;

					default:
						break;
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
