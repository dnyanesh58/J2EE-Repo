package Tester;
import static Utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.*;

public class SaveImage 
{
	public static void main(String[] args) 
	{
		try(SessionFactory sf = getfactory(); Scanner sc = new Scanner(System.in);)
		{
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter the Id & filename");
			System.out.println(dao.saveImage(sc.nextInt(), sc.next()));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
