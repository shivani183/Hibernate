package in.ineuron.test;

import in.ineuron.dao.ITransferDao;
import in.ineuron.dao.TransferDaoImpl;
import in.ineuron.util.schoolMySQLHibernateUtil;
import in.ineuron.util.libraryMySQLHibernateUtil;

public class InteractWithMultipleDB {

	public static void main(String[] args) throws Exception {

		ITransferDao dao = new TransferDaoImpl();
		System.out.println(dao.transferProductById(1));

		libraryMySQLHibernateUtil.closeSessionFactory();
		schoolMySQLHibernateUtil.closeSessionFactory();

	}
}

