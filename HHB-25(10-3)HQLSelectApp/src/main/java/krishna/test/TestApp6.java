package krishna.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import krishna.model.Products;
import krishna.util.HibernateUtil;

public class TestApp6 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Query<Products> query = session
					.createQuery("FROM krishna.model.Products WHERE pid=:id ");
			
			System.out.println("Enter Id for Records");
			int id=new Scanner(System.in).nextInt();
			query.setParameter("id", id);
			
			Products uniqueResult = query.uniqueResult();
			
			if(uniqueResult!=null) {
				System.out.println(uniqueResult);
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
