package krishna.test;

import java.util.List;


import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import krishna.model.bankAccount;
import krishna.util.HibernateUtil;

public class SelectAppNativeQuery {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Filter filter = session.enableFilter("FILTER_BANK_ACC_STATUS");
			filter.setParameter("accType1", "blocked");
			filter.setParameter("accType2", "closed");

			NativeQuery<bankAccount> nQuery = session.createSQLQuery("slect * from bank where balance >=:amt");

			nQuery.setParameter("amt", 2000.0f);
			
			nQuery.addEntity(bankAccount.class);
			
			List<bankAccount> list = nQuery.list();
			list.forEach(System.out::println);

			System.out.println();

			session.disableFilter("FILTER_BANK_ACC_STATUS");
			NativeQuery<bankAccount> query1 = session.createSQLQuery("select * from bank where balance >=:amt");
			query1.addEntity(bankAccount.class);

			query1.setParameter("amt", 2000.0f);
			List<bankAccount> list1 = query1.list();
			list1.forEach(System.out::println);

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
