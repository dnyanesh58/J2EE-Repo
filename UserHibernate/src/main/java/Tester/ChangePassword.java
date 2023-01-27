package Tester;

import org.hibernate.SessionFactory;
import static Utils.HibernateUtils.*;

import java.util.Scanner;

import Dao.*;
import Pojos.User;

public class ChangePassword 
{
	public static void main(String[] args) 
	{
		try(SessionFactory sf = getfactory(); Scanner sc = new Scanner(System.in);)
		{
			UserDaoImpl userdao = new UserDaoImpl();
			System.out.println("Enter the email & oldpass & newpass");
			User user = userdao.changePassword(sc.next(), sc.next(),sc.next());
			System.out.println(user);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
