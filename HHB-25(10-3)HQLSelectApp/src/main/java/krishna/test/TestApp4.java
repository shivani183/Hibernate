package krishna.test;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import krishna.model.Products;
import krishna.util.HibernateUtil;

public class TestApp4 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Query<Integer> query = session
					.createQuery("SELECT price FROM krishna.model.Products WHERE pname IN(:prdt1,:prdt2)");
			query.setParameter("prdt1", "sugar");
			query.setParameter("prdt2", "omega");
			
			List<Integer> list = query.list();
			List<Integer> list1 = query.getResultList();
			System.out.println("PRICE");
			
			list.forEach(System.out::println);
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
