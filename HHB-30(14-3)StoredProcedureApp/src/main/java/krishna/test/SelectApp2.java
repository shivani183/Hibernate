package krishna.test;

import java.util.List;


import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

import krishna.model.Product;
import krishna.util.HibernateUtil;

/*CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_PRODUCTS_DETAILS_BY_ID`(IN ID INT,OUT NAME VARCHAR(30),OUT RATE INT, OUT QNT INT)
BEGIN
SELECT pname, price, quantity INTO NAME,RATE,QNT FROM PRODUCT WHERE PID =ID; 
END*/

public class SelectApp2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();
			Integer pid=1;
			
			
			//creating procedure call obj
			ProcedureCall procedureCall = session.createStoredProcedureCall("GET_PRODUCTS_DETAILS_BY_ID");
			
			//binding input and output
			procedureCall.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(pid);
			procedureCall.registerParameter(2, String.class, ParameterMode.OUT);
			procedureCall.registerParameter(3, Integer.class, ParameterMode.OUT);
			procedureCall.registerParameter(4, Integer.class, ParameterMode.OUT);
			
			
			String pname = (String)procedureCall.getOutputParameterValue(2);
			Integer price = (Integer)procedureCall.getOutputParameterValue(3);
			Integer qty = (Integer)procedureCall.getOutputParameterValue(4);
			
			System.out.println(pname+"\t"+price+"\t"+qty);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
