package Tester;

import static Utils.HibernateUtils.*;

import java.time.LocalDate;
import java.util.Scanner;

import Dao.*;
import org.hibernate.SessionFactory;

public class BulkDiscountApply 
{
	public static void main(String[] args) 
	{
		try(SessionFactory sf = getfactory(); Scanner sc = new Scanner(System.in);)
		{
			UserDaoImpl userdao = new UserDaoImpl();
			System.out.println("Enter the date & discount");
			System.out.println(userdao.applyBulkDiscount(LocalDate.parse(sc.next()),sc.nextDouble()));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
