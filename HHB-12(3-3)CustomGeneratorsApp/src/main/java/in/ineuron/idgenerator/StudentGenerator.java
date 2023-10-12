package in.ineuron.idgenerator;

import java.util.Date;
import java.util.Random;
import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		/*
		 * System.out.println("StudentGenerator.generate()"); String id = "IN-01";
		 * return id;
		 */

		String date = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
		int num = new Random().nextInt();
		String prefix1 = "ineuron-";
		String prefix2 = "HB";
		return prefix1 + date + prefix2 + "-" + num;
	}

}
