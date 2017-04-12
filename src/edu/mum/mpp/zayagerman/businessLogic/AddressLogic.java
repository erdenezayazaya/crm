package edu.mum.mpp.zayagerman.businessLogic;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.mum.mpp.zayagerman.client.Address;
import edu.mum.mpp.zayagerman.client.ClientBasic;

public class AddressLogic {
	public static boolean createActivities(int clientId, Address address)
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
    
		clientBasic.get(0).addAddressList(address);    	
    	
    	session.update(clientBasic);
    	    	
    	transaction.commit();
    	session.close();
    	
   
    	session = factory.openSession();
    	
    	transaction=session.beginTransaction();  
    	
    	session.persist(address);
    	    	
    	transaction.commit();
    	session.close();
    	    	
    	return true;
	}
}
