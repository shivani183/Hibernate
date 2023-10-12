package krishna.test;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import krishna.model.Products;
import krishna.util.HibernateUtil;

public class TestApp7 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Query<Products> query = session.createQuery("FROM krishna.model.Products WHERE pid=:id ");

			System.out.println("Enter Id for Records");

			@SuppressWarnings("resource")
			int id = new Scanner(System.in).nextInt();
			query.setParameter("id", id);

			Optional<Products> resultOptional = query.uniqueResultOptional();

			if (resultOptional.isPresent()) {
				System.out.println(resultOptional);
			} else
				System.out.println("Record not available at " + id);

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
