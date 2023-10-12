package in.ineuron.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;

import in.ineuron.model.ProgrammerProjID;
import in.ineuron.model.ProgrammerProjINFO;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				ProgrammerProjID id = new ProgrammerProjID();
				id.setPid(100);
				id.setProjId(500);
				ProgrammerProjINFO object = session.get(ProgrammerProjINFO.class, id);
				if (object != null)
					System.out.println(object);
				else
					System.out.println("Record not available for the given id :: " + id);
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
