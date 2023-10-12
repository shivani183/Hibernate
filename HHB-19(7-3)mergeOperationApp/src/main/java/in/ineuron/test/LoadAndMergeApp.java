package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class LoadAndMergeApp {

	public static void main(String[] args) throws Exception {

		Student student =null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			
			
			session = HibernateUtil.getSession();

			Student std1 = session.get(Student.class, 3);
			System.out.println("After loading data in L1 cache : "+std1);
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Student std2 = new Student();
				std2.setSid(3);
				std2.setSname("yuvi");
				std2.setSage(40);
				std2.setSaddress("jalandhar");
				Student std3 = (Student) session.merge(std1);
				System.out.println("After merging in L1 cache : "+std3);
				System.out.println(std1.hashCode()+" : "+std2.hashCode()+" : "+std3.hashCode());

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
