package edu.mum.mpp.zayagerman.businessLogic;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.mum.mpp.zayagerman.activity.Activity;
import edu.mum.mpp.zayagerman.client.ClientBasic;

public class ActivityLogic {
	public static boolean createActivities(int clientId, Activity activity)
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	Query query = session.createQuery("FROM ClientBasic c WHERE c.id : id");
    	query.setParameter("id", clientId);
    	
    	@SuppressWarnings("unchecked")
		List<ClientBasic> clientBasic = query.list();
    
		clientBasic.get(0).addActivityList(activity);    	
    	
    	session.update(clientBasic);
    	    	
    	transaction.commit();
    	session.close();
    	
   
    	session = factory.openSession();
    	
    	transaction=session.beginTransaction();  
    	
    	session.persist(activity);
    	    	
    	transaction.commit();
    	session.close();
    	    	
    	return true;
	}
	
	public static Activity getAcitivity(int id)
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	Activity activity = (Activity) session.get(Activity.class, id);
    	    	
    	transaction.commit();
    	session.close();
    	
    	return activity;
	}
	
	public static List<Activity> getActivityList()
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	Query query = session.createQuery("FROM Activity");
    	
    	@SuppressWarnings("unchecked")
		List<Activity> list = query.list();    
    	    	
    	transaction.commit();
    	session.close();
    	
    	return list;
	}
}
