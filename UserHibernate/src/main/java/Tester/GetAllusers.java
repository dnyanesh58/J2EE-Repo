package Tester;

import org.hibernate.SessionFactory;
import static Utils.HibernateUtils.*;
import Dao.*;
import Pojos.User;

import java.util.List;
import java.util.Scanner;

public class GetAllusers {

	public static void main(String[] args) 
	{
		try(SessionFactory sf = getfactory(); Scanner sc = new Scanner(System.in);)
		{
			UserDaoImpl userdao = new UserDaoImpl();
			
			List<User> users = userdao.getAllUsers();
			
			if (users != null) {
				System.out.println(users);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}	
}
