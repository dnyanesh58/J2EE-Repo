package Tester;

import org.hibernate.SessionFactory;

import Pojos.Role;
import Pojos.User;

import static Utils.HibernateUtils.*;
import Dao.*;
import java.time.LocalDate;
import java.util.Scanner;

public class SaveNewUser {

	public static void main(String[] args) 
	{
		try(SessionFactory sf = getfactory(); Scanner sc = new Scanner(System.in);)
		{
			System.out.println("Enter the user details : name,email,password,confirmPass,regAmt,role,regDate,image");
			UserDaoImpl userDao = new UserDaoImpl();
			User user = new User(sc.next(),sc.next(),sc.next(),sc.next()
					,sc.nextDouble(),Role.valueOf(sc.next()),LocalDate.parse(sc.next()));
			userDao.saveNewUser(user);
			System.out.println("User created with id : "+user.getId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
