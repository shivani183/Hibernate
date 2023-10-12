package krishna.test;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import krishna.model.Products;
import krishna.util.HibernateUtil;

public class TestApp {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {

		Session session = null;
		try {
			session= HibernateUtil.getSession();
			
			Criteria criteria = session.createCriteria(Products.class);
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
