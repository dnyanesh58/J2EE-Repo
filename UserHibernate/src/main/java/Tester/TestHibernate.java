package Tester;

import static Utils.HibernateUtils.getfactory;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getfactory()) {
			System.out.println("Hibernate up n running ....." + sf);
		}//sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
