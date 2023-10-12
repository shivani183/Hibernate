package krishna.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import krishna.model.Products;
import krishna.util.HibernateUtil;

public class TestApp5 {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Criteria criteria = session.createCriteria(Products.class);
			ProjectionList list = Projections.projectionList();
			
			list.add(Projections.property("pname"));
			list.add(Projections.property("qty"));
			
			criteria.setProjection(list);
			
			Criterion cond1 = Restrictions.between("price", 500, 3000);
			Criterion cond2 = Restrictions.in("pname", "sugar", "fossil");
			Criterion cond3 = Restrictions.ilike("pname", "f%");
			
			Criterion finalcond = Restrictions.or(Restrictions.and(cond1,cond2),cond3);

			criteria.add(finalcond);

			Order order = Order.asc("pname");
			criteria.addOrder(order);

			List<Object[]> prdt = criteria.list();
			prdt.forEach(row->{
			for (Object obj:row) {
				System.out.println(obj);
			}System.out.println();
			});

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
