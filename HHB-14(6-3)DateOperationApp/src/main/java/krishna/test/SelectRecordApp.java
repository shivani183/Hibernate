package krishna.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import krishna.model.PersonInfo;
import krishna.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {

		Session session = null;
		Integer id = 1;
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				PersonInfo info = session.get(PersonInfo.class, id);
				if(info!=null)
					System.out.println(info);
				else
					System.out.println("Record not available for : "+id);
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
