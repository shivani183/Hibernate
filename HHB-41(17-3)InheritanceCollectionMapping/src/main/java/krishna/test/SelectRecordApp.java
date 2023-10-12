package krishna.test;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import krishna.model.Employee;
import krishna.util.HibernateUtil;

public class SelectRecordApp {

	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) {

		Session session=null;
		try {
			session = HibernateUtil.getSession();
			
			
			Query<Employee> query1 = session.createQuery("from krishna.model.Employee");
			List<Employee> list1 = query1.getResultList();
			list1.forEach(System.out::println);
			
           System.out.println();
			
			
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
		
	}

}
