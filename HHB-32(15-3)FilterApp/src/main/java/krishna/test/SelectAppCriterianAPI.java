package krishna.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.NativeQuery;

import krishna.model.bankAccount;
import krishna.util.HibernateUtil;

public class SelectAppCriterianAPI {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Filter filter = session.enableFilter("FILTER_BANK_ACC_STATUS");
			filter.setParameter("accType1", "blocked");
			filter.setParameter("accType2", "closed");

			Criteria criteria = session.createCriteria(bankAccount.class);
			Criterion cond = Restrictions.ge("balance", 2000f);
			criteria.add(cond);
			List<bankAccount> list = criteria.list();
			list.forEach(System.out::println);

			System.out.println();
			
			session.disableFilter("FILTER_BANK_ACC_STATUS");
			
			Criteria criteria1 = session.createCriteria(bankAccount.class);
			Criterion cond1 = Restrictions.ge("balance", 2000f);
			criteria1.add(cond1);
			List<bankAccount> list1 = criteria1.list();
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
