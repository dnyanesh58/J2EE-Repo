package Dao;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Pojos.Role;
import Pojos.User;
import net.bytebuddy.asm.Advice.Local;

import static Utils.HibernateUtils.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao
{

	@Override
	public String saveNewUser(User user) 
	{
		Session session = getfactory().openSession();
		
		Transaction tx = session.beginTransaction();
		try 
		{
			session.save(user);
			tx.commit();
		}
		catch (RuntimeException e) 
		{
			if (tx != null) 
				tx.rollback();
			throw e;
		}
		finally 
		{
			if (session != null)
			{
				session.close();
			}
		}
		return null;
	}

	@Override
	public User getUserById(int Id) 
	{
		User user;
		Session session = getfactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			 user = session.get(User.class, Id);
			tx.commit();
		}
		catch (RuntimeException e) 
		{
			if (tx != null) 
				tx.rollback();
			throw e;
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() 
	{
		Session session = getfactory().getCurrentSession();
		List<User> users = new ArrayList<User>();
		Transaction tx = session.beginTransaction();
		try 
		{
			users  = session.createQuery("select u from User u",User.class).getResultList();
			tx.commit();
		} 
		catch (RuntimeException e) 
		{
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public List<User> getSelectedUsers(LocalDate strtDate,LocalDate endDate,Role role) 
	{
		Session session = getfactory().getCurrentSession();
		List<User> users = new ArrayList<User>();
		Transaction tx = session.beginTransaction();
		try 
		{
			String jpql = "select u from User u where u.regDate between :start and :end and u.role = :role";
			users = session.createQuery(jpql,User.class)
					.setParameter("start", strtDate)
					.setParameter("end",endDate)
					.setParameter("role", role).getResultList();
			tx.commit();
		}
		catch (RuntimeException e) 
		{
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public User userLogin(String email, String pass)
	{
		User user = null;
		Session session = getfactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try 
		{
			user = session.createQuery("select u from User u where "
					+ "u.email= :em and u.password= :pass",User.class)
					.setParameter("em",email)
					.setParameter("pass", pass)
					.getSingleResult();
			tx.commit();
		}
		catch (RuntimeException e) 
		{
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return user;
	}

	@Override
	public List<String> getSelUserNames(LocalDate date) 
	{
		Session session = getfactory().getCurrentSession();
		List<String> allNames = new ArrayList<String>();
		Transaction tx = session.beginTransaction();
		try
		{
			String jpql = "select u.name from User u where u.regDate > :dt";
			allNames = session.createQuery(jpql,String.class).setParameter("dt",date).getResultList();
		} 
		catch (RuntimeException e) 
		{
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return allNames;
	}

	@Override
	public User changePassword(String email, String oldpass, String newpass) 
	{
		User user = null;
		Session session = getfactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			String jpql = "select u from User u where u.email=:em and u.password= :pass";
			user = session.createQuery(jpql,User.class)
					.setParameter("em",email)
					.setParameter("pass", oldpass)
					.getSingleResult();
			if (user != null) 
			{
				user.setPassword(newpass);
				System.out.println("Password updated");
			}
			else
			{
				System.out.println("Password updation failed");
			}
			tx.commit();
		} 
		catch (Exception e) 
		{
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return user;
	}

	@Override
	public String applyBulkDiscount(LocalDate date, double discount) 
	{
		String mesg = "bulk updation failed";
		Session session = getfactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try 
		{
			String jpql = "update User u set u.regAmt=u.regAmt - :disc where u.role= :role and u.regDate< :date";
			int count = session.createQuery(jpql).setParameter("disc",discount)
			.setParameter("role", Role.CUSTOMER).setParameter("date", date).executeUpdate();
			mesg = count + "users applied discount";
			tx.commit();
		} 
		catch (Exception e) 
		{
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String unSubscribeUser(int Id) 
	{
		String mesg = "unsubscription failed";
		Session session = getfactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try 
		{
			User user = session.get(User.class, Id);
			session.delete(user);
			tx.commit();
			mesg = "unsubsciption done sucess";
		}
		catch (RuntimeException e) 
		{
			if(tx != null)
				tx.rollback();
		}
		return mesg;
	}

	@Override
	public String saveImage(int Id, String fileName) throws IOException 
	{
		StringBuilder mesg = new StringBuilder("Image storing :  ");
		Session session = getfactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			User user = session.get(User.class,Id);
			if (user != null) 
			{
				File file = new File(fileName);
				if (file.isFile() && file.canRead()) 
				{
					user.setImage(FileUtils.readFileToByteArray(file));
					mesg.append("image saved ....");
				} 
				else 
				{
					mesg.append(" Failed : Invalid File name!!!!!!!!!!!!!!");
				}
			}
			else
			{
				mesg.append(" Failed : Invalid user id!!!!!!!!!!!!");
			}
			tx.commit();
		} 
		catch (Exception e) 
		{
			if(tx != null)
				tx.rollback();
		}
		return mesg.toString();
	}

	@Override
	public String readImage(int Id, String newfileName) throws IOException 
	{
		Session session = getfactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		StringBuilder mesg = new StringBuilder("Image restoring.....");
		try
		{
			User user = session.get(User.class, Id);
			if (user != null) 
			{
				File file = new File(newfileName);
				FileUtils.writeByteArrayToFile(file,user.getImage());
				mesg.append("Success....");
			}
			else
			{
				mesg.append("Failed...Invalid User");
			}
		}
		catch (Exception e) 
		{
			if(tx != null)
				tx.rollback();
		}
		return mesg.toString();
	}
}
