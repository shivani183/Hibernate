package krishna.util;

import org.hibernate.Session;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import krishna.model.CardPayment;
import krishna.model.ChequePayment;
import krishna.model.Payment;


public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	private HibernateUtil() {
	}

	static {
		sessionFactory = new Configuration().configure().
				addAnnotatedClass(Payment.class).
				addAnnotatedClass(CardPayment.class).
				addAnnotatedClass(ChequePayment.class).
				 buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null)
			session = sessionFactory.openSession();
		return session;
	}

	public static void closeSession(Session session) {
		if (session != null)
			session.close();
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null)
			sessionFactory.close();
	}

}
