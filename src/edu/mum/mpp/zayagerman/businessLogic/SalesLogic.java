package edu.mum.mpp.zayagerman.businessLogic;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.mum.mpp.zayagerman.client.ClientBasic;
import edu.mum.mpp.zayagerman.sale.Sale;

public class SalesLogic {
	public static boolean createSale(int clientId, Sale sale)
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
    
		clientBasic.get(0).addSaleList(sale);   	
    	
    	session.update(clientBasic);
    	    	
    	transaction.commit();
    	session.close();
    	
   
    	session = factory.openSession();
    	
    	transaction=session.beginTransaction();  
    	
    	session.persist(sale);
    	    	
    	transaction.commit();
    	session.close();
    	    	
    	return true;
	}
}
