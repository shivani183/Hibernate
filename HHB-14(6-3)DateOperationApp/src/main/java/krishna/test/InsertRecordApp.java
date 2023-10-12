package krishna.test;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import krishna.model.PersonInfo;
import krishna.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Integer id=null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				PersonInfo personInfo = new PersonInfo();
				personInfo.setPname("sachin");
				personInfo.setDob(LocalDate.of(1980, 04, 20));
				personInfo.setDom(LocalDateTime.of(1991, 03, 10, 15, 57));
				personInfo.setDoj(LocalTime.of(17, 30));
				id = (Integer) session.save(personInfo);
		
				
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to database with.. "+id);
			} else {
				transaction.rollback();
				System.out.println("Object not saved to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
