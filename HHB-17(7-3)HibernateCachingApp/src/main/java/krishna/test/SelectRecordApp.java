package krishna.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import krishna.model.InsurancePolicy;
import krishna.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {

		Session session = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				InsurancePolicy policy1 = session.get(InsurancePolicy.class, 1L);
				System.out.println("1:: " + policy1); // 1Lgets from db
				System.out.println("*************************************************************");
				
				InsurancePolicy policy2 = session.get(InsurancePolicy.class, 1L);
				System.out.println("2:: " + policy2);// 1L gets from session l1 cache
				System.out.println("*************************************************************");
				
				session.evict(policy1);
				InsurancePolicy policy3 = session.get(InsurancePolicy.class, 1L);
				System.out.println("3:: " + policy3); // 1Lgets from db
				System.out.println("*************************************************************");
				
				InsurancePolicy policy4 = session.get(InsurancePolicy.class, 1L);
				System.out.println("4:: " + policy4);// 1L gets from session l1 cache
				System.out.println("*************************************************************");
				
				InsurancePolicy policy5 = session.get(InsurancePolicy.class, 2L);
				System.out.println("5:: " + policy5); //2L gets from db
				System.out.println("*************************************************************");
			
				session.clear();
				
				InsurancePolicy policy6 = session.get(InsurancePolicy.class, 1L);
				System.out.println("6:: " + policy6);//1L gets from db
				System.out.println("*************************************************************");
				
				InsurancePolicy policy7 = session.get(InsurancePolicy.class, 2L);
				System.out.println("7:: " + policy7);//2L gets from db
				System.out.println("*************************************************************");
			}

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
