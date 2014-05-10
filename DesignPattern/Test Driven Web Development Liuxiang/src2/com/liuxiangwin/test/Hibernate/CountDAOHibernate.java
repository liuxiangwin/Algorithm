package com.liuxiangwin.test.Hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CountDAOHibernate {

	
	public List<SlotDetailMeter> queryByNativeSql()
	{
		List<SlotDetailMeter> returnList=new ArrayList<SlotDetailMeter>();
		
		Session session = CountDAOHibernate.buildSessionFactory().openSession();

		session.beginTransaction();

		Query query = session.createSQLQuery("select soft_count," +
				"hard_count,drop_date  from caslnk.slot_detail_meter");
		
	    List list=query.list();
		for(Iterator iter=list.iterator();iter.hasNext();)
		{
			//Every iterator element in the  list is Object Array
			Object[] row=(Object[])iter.next();
			double softCount = ((BigDecimal) row[0]).doubleValue();
			double hardCount = ((BigDecimal) row[1]).doubleValue();
			Date dropDate=(Date)row[2];
			returnList.add(new SlotDetailMeter(softCount, hardCount, dropDate));
			
		}
		return returnList;
	}
	
	
	public List<SlotDetailMeter> queryFromDB() {

		Session session = CountDAOHibernate.buildSessionFactory().openSession();

		session.beginTransaction();

		Query query = session.createQuery("from SlotDetailMeter");

		List<SlotDetailMeter> slotMeterList = query.list();
		return slotMeterList;
	}

	private static SessionFactory buildSessionFactory() {
		try {
			// SessionFactory sessionFactory = new
			// Configuration().configure().buildSessionFactory();

			// load from different directory
			SessionFactory sessionFactory = new Configuration().configure(
					"/com/liuxiangwin/test/Hibernate/Hibernate-Config.xml")
					.buildSessionFactory();

			return sessionFactory;

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	
	public static void main(String args[])
	{
		CountDAOHibernate countDaoHibernate=new CountDAOHibernate();
		//List<SlotDetailMeter> slotMeterList=countDaoHibernate.queryFromDB();
		List<SlotDetailMeter> slotMeterList=countDaoHibernate.queryByNativeSql();
		for(SlotDetailMeter slotMeter:slotMeterList)
		{
			System.out.println(slotMeter.get_softCount());
			System.out.println(slotMeter.get_hardCount());
			System.out.println(slotMeter.get_dropDate());

			
		}
		
		
	}

}
