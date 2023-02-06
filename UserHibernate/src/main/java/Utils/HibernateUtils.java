package Utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class HibernateUtils 
{
	private static SessionFactory factory;
	
	static
	{
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getfactory()
	{
		return factory;
	}
}
