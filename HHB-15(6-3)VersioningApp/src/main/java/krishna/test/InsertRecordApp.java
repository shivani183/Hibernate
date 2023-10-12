package krishna.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import krishna.model.MobileCustomer;
import krishna.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Integer id = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				MobileCustomer customer = new MobileCustomer();
				customer.setCname("shivani singh");
				customer.setMobileNo(9453625435L);
				customer.setCallerTune("rang de basanti..");
				id = (Integer) session.save(customer);
				
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to database with.. " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not saved to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
