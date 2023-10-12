package krishna.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import krishna.model.bankAccount;
import krishna.util.HibernateUtil;

public class DeleteRecordUsingHQL {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		int row=0;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			
			/*
			 * Query query = session.
			 * createQuery("UPDATE FROM krishna.model.bankAccount SET status='closed 'where accno=:no"
			 * );
			 */			
			
			//to delete the row record-
			Query query = session.createQuery("DELETE FROM krishna.model.bankAccount where accno=:no");
			query.setParameter("no", 183209);
			row=query.executeUpdate();
			
			
			flag = true;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("record deleted "+ row);
			} else {
				transaction.rollback();
				System.out.println("record status not changed");

			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
