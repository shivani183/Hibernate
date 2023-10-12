package in.ineuron.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class PropertiesApp {

	public static void main(String[] args) throws Exception {
		int id=8;

		try {
			Configuration configuration = new Configuration();
			//configuration will search for hibernate.properties
			
			configuration.addAnnotatedClass(Student.class);
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Student student = session.get(Student.class, id);

			if (student != null) {
				System.out.println(student);
			} else
				System.out.println("Record available for given record " + id);

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

}
