package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		int id=8;
		try {
			session = HibernateUtil.getSession();
			Student student = session.get(Student.class, id);
			System.out.println("Before updation "+ student);

			if (student != null) {
				System.in.read();
				session.refresh(student);
				System.out.println("After updation "+ student);
			}else
				System.out.println("Record available for given record "+ id);
				
				

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
