package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Product;
import in.ineuron.util.schoolMySQLHibernateUtil;
import in.ineuron.util.libraryMySQLHibernateUtil;

public class TransferDaoImpl implements ITransferDao {

	@SuppressWarnings("finally")
	@Override
	public String transferProductById(Integer id) {

		Session librarySession = libraryMySQLHibernateUtil.getSession();
		Session schoolSession = schoolMySQLHibernateUtil.getSession();
		Integer idValue = 0;
		Boolean flag = false;

		Transaction libraryTransaction = null;

		Product product = schoolSession.get(Product.class, id);

		if (product == null) {
			return "Record not available for copying....";
		} else {

			try {
				libraryTransaction = librarySession.beginTransaction();
				idValue = (Integer) librarySession.save(product);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (flag) {
					libraryTransaction.commit();
					return "Data copied from oracle to mysql with the id :: " + idValue;
				} else {
					libraryTransaction.rollback();
					return "Data not copied from oracle to mysql with the id :: " + idValue;
				}
			}
		}

	}

}
