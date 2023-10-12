package krishna.test;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import krishna.model.jobSeeker;
import krishna.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		Integer id = null;
		boolean flag = false;
		byte[] photo=null;
		char[] resume =null;

		//copying image data to byte[]
		try (FileInputStream fis = new FileInputStream("/Users/avinashsingh/Downloads/A%201354-2.jpg")) {
			photo = new byte[fis.available()];
			fis.read(photo);
		}
		//copying resume data in char[]
		try {
			File f = new File("/Users/avinashsingh/Downloads/SHIVANI_RESUME.pdf");
			try (FileReader fr = new FileReader(f)) {
				resume = new char[(int) f.length()];
				fr.read(resume);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				jobSeeker seeker = new jobSeeker();
				seeker.setJsName("shivani");
				seeker.setJsAddress("RBTS");
				seeker.setPhoto(photo);
				seeker.setReusme(resume);
				id = (Integer) session.save(seeker);
				
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to database with.. " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not saved to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
