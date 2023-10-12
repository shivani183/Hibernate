package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class mergeRecordApp {

	public static void main(String[] args) throws Exception {

		Student student =null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Student std=null;
		try {
			student = new Student();
			student.setSid(3);
			student.setSname("yuvi");
			student.setSaddress("jalandhar");
			student.setSage(40);
			
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				std=(Student) session.merge(student);

				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println(student);
				System.out.println("Object saved to database....");
			} else {
				transaction.rollback();
				System.out.println("Object not saved to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
