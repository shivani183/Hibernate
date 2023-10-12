package krishna.test;

import java.util.List;


import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

import krishna.model.Product;
import krishna.util.HibernateUtil;

/*
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_PRODUCTs_BY_NAME`(IN NAME1 VARCHAR(20), IN NAME2 VARCHAR(20))
BEGIN
SELECT pid, pname,price, qty from product where pname in (name1, name2);
END
*/

public class SelectApp {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();
			String product1 = "fossil";
			String product2 = "sugar";

			// Creating a Procedure call object
			ProcedureCall procedureCall = session.createStoredProcedureCall("GET_PRODUCTs_BY_NAME", Product.class);

			// Binding input parameter value for Procedure call object
			procedureCall.registerParameter(1, String.class, ParameterMode.IN).bindValue(product1);
			procedureCall.registerParameter(2, String.class, ParameterMode.IN).bindValue(product2);

			// Executing the store procedure to get the result
			List<Product> product = procedureCall.getResultList();

			// Processing the result
			product.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
