package krishna.test;

import krishna.dao.InsurancePolicyDaoImpl;

public class InsertApp {
	public static void main(String[] args) {
		
		InsurancePolicyDaoImpl daoImpl = new InsurancePolicyDaoImpl();
		String result = daoImpl.transferPolicies(15);
		System.out.println(result);
	}
}
