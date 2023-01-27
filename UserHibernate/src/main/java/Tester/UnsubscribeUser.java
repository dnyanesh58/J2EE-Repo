package Tester;
import static Utils.HibernateUtils.*;
import Dao.*;
import java.util.Scanner;

import org.hibernate.SessionFactory;

public class UnsubscribeUser 
{
	public static void main(String[] args) 
	{
		try (SessionFactory sf = getfactory(); Scanner sc = new Scanner(System.in);)
		{
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter the userid : ");
			System.out.println(dao.unSubscribeUser(sc.nextInt()));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
