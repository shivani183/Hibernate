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
				System.out.println("1:: " + policy1); //get from database put in L1 and L2 cache
				System.out.println("*************************************************************");
				
				InsurancePolicy policy2 = session.get(InsurancePolicy.class, 1L);
				System.out.println("2:: " + policy2); // get from L1 cache
				System.out.println("*************************************************************");
				
				session.evict(policy1); //remove policy obj from L1 cache
				
				InsurancePolicy policy3 = session.get(InsurancePolicy.class, 1L);
				System.out.println("3:: " + policy3);// get from L2 cache & put in L1 cache
				System.out.println("*************************************************************");
				
				session.clear(); //remove all obj from L1cache
				Thread.sleep(20000); //20secs(idle timeout is expired so obj removed from L2 cache)
				System.out.println();
				InsurancePolicy policy4 = session.get(InsurancePolicy.class, 1L);
				System.out.println("4:: " + policy4);// get from L2 cache & put in L1 cache
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
