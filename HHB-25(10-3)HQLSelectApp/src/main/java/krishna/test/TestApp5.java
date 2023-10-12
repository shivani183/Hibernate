package krishna.test;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import krishna.model.Products;
import krishna.util.HibernateUtil;

public class TestApp5 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Query<Products> query = session
					.createQuery("FROM krishna.model.Products WHERE pid=:id ");
			int id=11;
			query.setParameter("id", id);
			
			List<Products> list = query.list();
			System.out.println(list.size());
			
			if(!list.isEmpty()) {
				Products product = list.get(0);
				System.out.println(product);
			}else
				System.out.println("Record not available at "+id);
			

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
