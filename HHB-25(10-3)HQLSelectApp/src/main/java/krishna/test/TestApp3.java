package krishna.test;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import krishna.model.Products;
import krishna.util.HibernateUtil;

public class TestApp3 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Query<Object[]> query = session.createQuery("SELECT pname, qty FROM krishna.model.Products WHERE pname IN(:prdt1,:prdt2)");
			query.setParameter("prdt1", "sugar");
			query.setParameter("prdt2", "omega");
			
			//Execute the query
			List<Object[]> list = query.list();
			System.out.println("PRICE\tQTY");
			
			//process the list object
			list.forEach(row->{;
			for(Object obj:row) {
				System.out.print(obj+"\t");
			}
			System.out.println();
			});

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
