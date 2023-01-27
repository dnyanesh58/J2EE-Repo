package Tester;

import org.hibernate.SessionFactory;

import Pojos.Role;
import Pojos.User;

import static Utils.HibernateUtils.*;

import Dao.UserDaoImpl;
import Dao.UserDaoImpl.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetSelectedUsers 
{
	public static void main(String[] args) 
	{
		try(SessionFactory sf = getfactory(); Scanner sc = new Scanner(System.in);)
		{
			List<User> users = new ArrayList<User>();
			System.out.println("Enter the start n end date (y-m-d) and role ");
			UserDaoImpl userdao = new UserDaoImpl();
			users = userdao.getSelectedUsers(LocalDate.parse(sc.next()),
					LocalDate.parse(sc.next()),Role.valueOf(sc.next().toUpperCase()));
			System.out.println(users);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
