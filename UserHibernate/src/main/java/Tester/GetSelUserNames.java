package Tester;

import static Utils.HibernateUtils.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.*;

public class GetSelUserNames 
{
	public static void main(String[] args) 
	{
		try(SessionFactory sf = getfactory(); Scanner sc = new Scanner(System.in))
		{
			UserDaoImpl userdao = new UserDaoImpl();
			System.out.println("Enter the date : ");
			List<String> allNames = userdao.getSelUserNames(LocalDate.parse(sc.next()));
			System.out.println(allNames);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
