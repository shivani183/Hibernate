package krishna.test;

import java.io.Serializable;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import krishna.model.BankAccount;
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
				BankAccount bankAccount = new BankAccount();
				bankAccount.setBalance(87638.98);
				bankAccount.setHolderName("shivani");
				bankAccount.setType("saving");
				
				id = (Long) session.save(bankAccount);
				
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
