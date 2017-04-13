package edu.mum.mpp.zayagerman.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import edu.mum.mpp.zayagerman.dto.ClientData;

public class ClientFactory {
	
    public ClientFactory() {
    	super();
    }
    
    public static ClientBasic getClient(int id)
    {
    /*	Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");*/
    	
    	try{
    		SessionFactory factory = ((AnnotationConfiguration) new AnnotationConfiguration().
                      configure()).
                      //addPackage("com.xyz") //add package if used.
                      addAnnotatedClass(ClientBasic.class).
                      buildSessionFactory();
         }catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
         }
    	
//    	SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
//    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	Query query=session.createQuery("FROM ClientBasic c WHERE c.id = :id");
    	query.setParameter("id", id);
    	
    	@SuppressWarnings("unchecked")
    	List<ClientBasic> clientBasic = query.list(); 
    	    	
    	transaction.commit();
    	session.close();
    	
    	return clientBasic.get(0);
    }
    
    public static List<ClientLead> getLeads(){
    	/*Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");*/
    	
    	SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	Query query=session.createQuery("FROM ClientLead");
    
    	@SuppressWarnings("unchecked")
		List<ClientLead> list = query.list();  	
    	
    	transaction.commit();
    	session.close();
    	
    	return list;    	
    }
    
    public static List<ClientOpportunity> getOportunities(){
    /*	Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");*/
    	
    	SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	Query query=session.createQuery("FROM ClientOpportunity");
    
    	@SuppressWarnings("unchecked")
		List<ClientOpportunity> list = query.list();  	
    	
    	transaction.commit();
    	session.close();
    	
    	return list;   
    }
    
    public static List<ClientBasic> getClientBasics()
    {
    	/*Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");*/
    	
    	SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	Query query=session.createQuery("FROM ClientBasic");
    
    	@SuppressWarnings("unchecked")
		List<ClientBasic> list = query.list();  	
    	
    	transaction.commit();
    	session.close();
    	
    	return list;
    }

    public static boolean createClient(ClientType type, ClientData client) {
    	
  /*  	Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");*/
 
    	SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
         	
    	if(type.equals(ClientType.CLIENTBASIC))
    	{
    		ClientBasic clientBasic = new ClientBasic();
    		
    		clientBasic.setFirstName(client.getClientFirstName());    	
    		clientBasic.setLastName(client.getClientLastName());
    		clientBasic.setEmail(client.getClientEmail());  
    		
    		session.persist(clientBasic);
    	}    	
        else if(type.equals(ClientType.LEAD)){
    		ClientLead clientLead = new ClientLead();
    		
    		clientLead.setSource(client.getLeadSource());
    		clientLead.setAmount(client.getLeadAmount());
    		clientLead.setDescription(client.getLeadDescription());
    		clientLead.setEmail(client.getClientEmail());
    		clientLead.setFirstName(client.getClientFirstName());
    		clientLead.setIndustry(client.getLeadIndustry());
    		clientLead.setLastName(client.getLeadIndustry());
    		clientLead.setStatus(client.getLeadStatus());  
    		
    		session.persist(clientLead);
    	}
        else if (type.equals(ClientType.OPPORTUNITY)){
    		ClientOpportunity clientOpportunity = new ClientOpportunity();
    		
    		clientOpportunity.setAmount(client.getOpporAmount());
    		clientOpportunity.setCloseDate(client.getOpporCloseDate());
    		clientOpportunity.setDescription(client.getOpporDescription());
    		clientOpportunity.setEmail(client.getClientEmail());
    		clientOpportunity.setFirstName(client.getClientFirstName());
    		clientOpportunity.setLastName(client.getClientLastName());
    		clientOpportunity.setProbability(client.getOpporProbability());
    		clientOpportunity.setStage(client.getOpporStage());
    		
    		session.persist(clientOpportunity);
    	}
    	
    	transaction.commit();
    	session.close();
    	
    	return true;
    }
}