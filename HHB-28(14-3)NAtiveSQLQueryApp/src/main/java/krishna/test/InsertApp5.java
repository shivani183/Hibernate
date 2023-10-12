package krishna.test;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import krishna.util.HibernateUtil;

public class InsertApp5 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			transaction=session.beginTransaction();
			NativeQuery nativeQuery = session
					.createSQLQuery("INSERT INTO INSURANCEPOLICY (policyName, policyType, tenure) VALUEs (?,?,?)");

			//Setting the positional parameter
			nativeQuery.setParameter(1, "jeevansathi");
			nativeQuery.setParameter(2, "yearly");
			nativeQuery.setParameter(3 ,10);
			flag=true;
			

			//Executing to get the result
			int count = nativeQuery.executeUpdate();			
			//Processing the result

		} catch (HibernateException he) {
			he.printStackTrace();
			flag=false;
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("record inserted");
			}else {
				transaction.rollback();
				System.out.println("record not inserted");
				
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
