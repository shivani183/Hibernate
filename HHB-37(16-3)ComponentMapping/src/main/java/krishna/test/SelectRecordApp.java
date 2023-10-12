package krishna.test;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import krishna.model.Address;
import krishna.model.StudentInfo;
import krishna.util.HibernateUtil;

public class SelectRecordApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			Query<StudentInfo> query = session.createQuery("from krishna.model.StudentInfo where address.cityName=:city");
			query.setParameter("city", "Bengaluru");

			List<StudentInfo> student = query.list();
			student.forEach(System.out::println);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
