package krishna.test;

import java.io.Serializable;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import krishna.model.InsurancePolicy;
import krishna.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Long id = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				InsurancePolicy policy = new InsurancePolicy();
				policy.setCompany("icicic");
				policy.setPolicyName("Jeevan SARAL");
				policy.setPolicyType("quaterly");
				policy.setTenure(5);
				id = (Long) session.save(policy);
				
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
