package krishna.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import krishna.model.MobileCustomer;
import krishna.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {

		Session session = null;
		Integer id = 1;
		boolean flag=false;
		MobileCustomer customer =null;
		Transaction transaction=null;
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				customer = session.get(MobileCustomer.class, id);
				System.out.println("Before modification : " +customer );
				transaction = session.beginTransaction();
				customer.setCallerTune("A mere vatan k logo..");
				session.update(customer);
				flag=true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Updation done in database..");
				System.out.println("After modification : " +customer );
			}else {
				transaction.rollback();
				System.out.println("Updation failed");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
