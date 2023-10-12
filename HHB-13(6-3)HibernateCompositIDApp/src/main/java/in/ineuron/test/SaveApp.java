package in.ineuron.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.ProgrammerProjID;
import in.ineuron.model.ProgrammerProjINFO;
import in.ineuron.util.HibernateUtil;

public class SaveApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		ProgrammerProjID pk =null;
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				ProgrammerProjID projID = new ProgrammerProjID();
				projID.setPid(100);
				projID.setProjId(502);
				
				ProgrammerProjINFO info = new ProgrammerProjINFO();
				info.setId(projID);
				info.setDeptNo(10);
				info.setPname("shivani");
				info.setProjName("IND");
				pk = (ProgrammerProjID)session.save(info);
				
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to database with.. "+pk);
			} else {
				transaction.rollback();
				System.out.println("Object not saved to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
