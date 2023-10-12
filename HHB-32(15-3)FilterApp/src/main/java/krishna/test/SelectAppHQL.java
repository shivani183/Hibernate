package krishna.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import krishna.model.bankAccount;
import krishna.util.HibernateUtil;

public class SelectAppHQL {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Filter filter = session.enableFilter("FILTER_BANK_ACC_STATUS");
			filter.setParameter("accType1", "blocked");
			filter.setParameter("accType2", "closed");

			Query<bankAccount> query = session.createQuery("from krishna.model.bankAccount where balance >=:amt");

			query.setParameter("amt", 2000.0f);
			List<bankAccount> list = query.list();
			list.forEach(System.out::println);

			System.out.println();

			session.disableFilter("FILTER_BANK_ACC_STATUS");
			Query<bankAccount> query1 = session.createQuery("from krishna.model.bankAccount where balance >=:amt");

			query1.setParameter("amt", 2000.0f);
			List<bankAccount> list1 = query.list();
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
