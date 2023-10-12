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

import krishna.model.InsurancePolicy;
import krishna.util.HibernateUtil;

public class SelectQueryApp {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Query<InsurancePolicy> query=session.createQuery("from krishna.model.InsurancePolicy ");
			query.setFirstResult(5);
			query.setMaxResults(2);
			List<InsurancePolicy> insure = query.list();
			insure.forEach(System.out::println);
			

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
