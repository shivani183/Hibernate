package krishna.test;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import krishna.util.HibernateUtil;

public class InsertApp4 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();

			NativeQuery<String> nativeQuery = session
					.createSQLQuery("SELECT policyName FROM INSURANCEPOLICY WHERE TENURE>=? AND TENURE<=?");

			//Setting the positional parameter
			nativeQuery.setParameter(1, 15);
			nativeQuery.setParameter(2, 30);
			

			//Executing to get the result
			List<String> policies = nativeQuery.getResultList();
			
			//Processing the result
			policies.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
