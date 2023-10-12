package krishna.test;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import krishna.model.InsurancePolicy;
import krishna.util.HibernateUtil;

public class ClientApp_2 {

	public static void main(String[] args) {

		Session session = null;
		Integer id = 1;
		boolean flag = false;
		Transaction transaction = null;
		session= HibernateUtil.getSession();
		try {
			transaction = session.beginTransaction();
			InsurancePolicy policy = session.get(InsurancePolicy.class, id, LockMode.UPGRADE_NOWAIT);
			System.out.println(policy);
			policy.setTenure(25);
			flag = true;

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Updation done in database..");
				System.out.println("After modification : ");
			} else {
				transaction.rollback();
				System.out.println("Updation failed");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
