package krishna.test;

import org.hibernate.HibernateException;


import org.hibernate.Session;
import org.hibernate.Transaction;

import krishna.model.BankAccount;
import krishna.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {

		Session session = null;
		long id = 1L;
		boolean flag = false;
		Transaction transaction = null;
		BankAccount account = null;
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				account = session.get(BankAccount.class, id);
				System.out.println("before modification " + account);
				if (account != null) {
					account.setBalance(account.getBalance() + 10000);
					flag = true;
				} else
					System.out.println("Record not found for this id " + id);

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Updation done in database..");
				System.out.println("Account created at : " + account.getOpeningDate());
				System.out.println("Account last modification : " + account.getLastUpdated());
				System.out.println("Account version count: " + account.getCount());
			} else {
				transaction.rollback();
				System.out.println("Updation failed");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
