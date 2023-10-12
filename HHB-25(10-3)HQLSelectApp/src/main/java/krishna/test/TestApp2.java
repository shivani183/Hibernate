package krishna.test;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import krishna.model.Products;
import krishna.util.HibernateUtil;

public class TestApp2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			// prepare query obj to hold HQL
			Query<Products> query = session.createQuery("FROM krishna.model.Products WHERE pname IN(:prdt1,:prdt2)");

			// set values to named parameter
			query.setParameter("prdt1", "sugar");
			query.setParameter("prdt2", "omega");

			// execute the query(select * from)
			List<Products> list = query.list();
			list.forEach(System.out::println);

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
