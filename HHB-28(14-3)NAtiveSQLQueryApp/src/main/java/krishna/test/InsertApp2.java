package krishna.test;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import krishna.model.InsurancePolicy;
import krishna.util.HibernateUtil;

public class InsertApp2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();

			NativeQuery<InsurancePolicy> nativeQuery = session
					.createSQLQuery("SELECT * FROM INSURANCEPOLICY WHERE TENURE>=:max AND TENURE<=:min");

			//Setting the named parameter
			nativeQuery.setParameter("max", 15);
			nativeQuery.setParameter("min", 30);
			
			nativeQuery.addEntity(InsurancePolicy.class);
			//Executing to get the result
			List<InsurancePolicy> policies = nativeQuery.getResultList();
			
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
