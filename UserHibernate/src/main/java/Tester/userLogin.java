package Tester;

import static Utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.*;
import Pojos.User;

public class userLogin 
{
	public static void main(String[] args) 
	{
		try(SessionFactory sf = getfactory(); Scanner sc = new Scanner(System.in);)
		{
			UserDaoImpl userdao = new UserDaoImpl();
			System.out.println("Enter the email & password");
			User user = userdao.userLogin(sc.next(), sc.next());
			System.out.println(user);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
