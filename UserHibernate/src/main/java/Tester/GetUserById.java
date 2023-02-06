package Tester;

import org.hibernate.SessionFactory;
import static Utils.HibernateUtils.*;
import Dao.*;
import Pojos.User;

import java.util.Scanner;
public class GetUserById {

	public static void main(String[] args) 
	{
		try (SessionFactory sf = getfactory(); Scanner sc = new Scanner(System.in);)
		{
			UserDaoImpl userdao = new UserDaoImpl();
			System.out.println("Enter the Id : ");
			User user = userdao.getUserById(sc.nextInt());
			System.out.println(user);
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}

}
