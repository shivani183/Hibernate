package krishna.test;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.Query;

import krishna.model.Products;
import krishna.util.HibernateUtil;

public class TestApp2 {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {

		Session session = null;
		try {
			session= HibernateUtil.getSession();
			
			Criteria criteria = session.createCriteria(Products.class);
			
			Criterion cond1 = Restrictions.ge("price", 2000);
			Criterion cond2 = Restrictions.le("price", 3000);
			
			criteria.add(cond1);
			criteria.add(cond2);
			
			List <Products> prdt = criteria.list();
			prdt.forEach(System.out::println);

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
