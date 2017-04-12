package edu.mum.mpp.zayagerman.businessLogic;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import edu.mum.mpp.zayagerman.campaign.Campaign;

public class CampaignLogic {
	public static boolean createCampaign(Campaign campaign)
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	session.persist(campaign);
    	    	
    	transaction.commit();
    	session.close();
    	    	
    	return true;
	}
	
	public static Campaign getCampaign(int id)
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	Campaign campaign = (Campaign) session.get(Campaign.class, id);
    	    	
    	transaction.commit();
    	session.close();
    	
    	return campaign;
	}
	
	public static List<Campaign> getActivityList()
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	Query query = session.createQuery("FROM Campaign");
    	
    	@SuppressWarnings("unchecked")
		List<Campaign> list = query.list();    
    	    	
    	transaction.commit();
    	session.close();
    	
    	return list;
	}
}
