package krishna.test;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import krishna.util.HibernateUtil;

public class SelectApp {
	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();

			NativeQuery<Object[]> nativeQuery = session.getNamedNativeQuery("GET_ALL_POLICIES_TYPE");

			nativeQuery.setParameter(1, "year");

			List<Object[]> policies = nativeQuery.getResultList();

			System.out.println("PID\tPNAME\t\tTYPE");
			policies.forEach(row -> {
				for (Object object : row) {
					System.out.print(object + "\t");
				}
				System.out.println();
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
