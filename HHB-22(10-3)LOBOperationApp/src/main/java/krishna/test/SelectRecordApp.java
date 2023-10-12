package krishna.test;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import krishna.model.jobSeeker;
import krishna.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {

		Session session = null;
		Integer id = 1;
		boolean flag = false;
		jobSeeker seeker = null;
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				seeker = session.get(jobSeeker.class, 1);
				if(seeker!=null) {
					System.out.println(" ID is : "+ seeker.getJsId());
					System.out.println(" Name is : "+ seeker.getJsName());
					System.out.println(" Address is : "+ seeker.getJsAddress());
					try(FileOutputStream fos =new FileOutputStream("./store/shivani.jpg");
							FileWriter writer=new FileWriter("./store.resume.txt")){
						fos.write(seeker.getPhoto());
						writer.write(seeker.getReusme());
					}
				}else {
					System.out.println("Updation failed");
				}

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
