package edu.mum.mpp.zayagerman.client;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;

import edu.mum.mpp.zayagerman.dto.ClientData;

public class ClientFactory {
	
    public ClientFactory() {
    	super();
    }
    
    /* Client Basic */
    
    public static ClientBasic getClientBasic(int id)
    {
	   Session session=new Configuration().configure("hibernate.cfg.xml")  
                  .buildSessionFactory().openSession();  
	   
	   Transaction t=null; 
	   
	   try{
		   t=session.beginTransaction();
		   
		   ClientBasic clientBasic = (ClientBasic) session.get(ClientBasic.class, id);
		   
		   t.commit();
		   
		   return clientBasic;
	   }
	   catch (HibernateException e) {
	         if (t!=null) t.rollback();
	         e.printStackTrace(); 
	   }
	   finally{
         session.close(); 
	   }
	   
	   return null;
    }
    
    public static List<ClientBasic> getClientBasics()
    {
	   Session session=new Configuration().configure("hibernate.cfg.xml")  
                 .buildSessionFactory().openSession();  
	   
	   Transaction t=null; 
	   
	   try{
		   t=session.beginTransaction();
		   
		//   Query query=session.createQuery("FROM ClientBasic");
		//   @SuppressWarnings("unchecked")
		 //  List<ClientBasic> list = query.list();  
		   
		 //  t.commit();
		   
		   return null;
	   }
	   catch (HibernateException e) {
	         if (t!=null) t.rollback();
	         e.printStackTrace(); 
	   }
	   finally{
        session.close(); 
	   }
	   
	   return null;    
    }
    
    public static void deleteClientBasic(int id)
    {
    	Session session=new Configuration().configure("hibernate.cfg.xml")  
                .buildSessionFactory().openSession();  
	   
	    Transaction t=null; 
	    
	    try{
	    	t=session.beginTransaction();
	    	
	    	ClientBasic clientBasic = (ClientBasic) session.get(ClientBasic.class, id);
	    	session.delete(clientBasic);
	    	t.commit();
	    }
	   catch (HibernateException e) {
	         if (t!=null) t.rollback();
	         e.printStackTrace(); 
	   }
	   finally{
      session.close(); 
	   }
    }
    
    public static void updateClientBasic(int id, ClientBasic client)
    {
    	Session session=new Configuration().configure("hibernate.cfg.xml")  
                .buildSessionFactory().openSession();  
	   
	    Transaction t=null; 
	    
	    try{
	    	t=session.beginTransaction();
	    	
	    	ClientBasic clientBasic = (ClientBasic) session.get(ClientBasic.class, id);
	    	session.update(clientBasic);
	    	t.commit();
	    }
	   catch (HibernateException e) {
	         if (t!=null) t.rollback();
	         e.printStackTrace(); 
	   }
	   finally{
      session.close(); 
	   }
    }
    
    public static boolean createClient(ClientType type, ClientData client) {
    	
    	
    
    	//creating configuration object  
        Configuration cfg=new Configuration();  
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
          
        //creating seession factory object  
        SessionFactory factory= AnnotationConfiguration().configure().buildSessionFactory();  
          
        //creating session object  
        Session session=factory.openSession(); 
	   
	    Transaction t=null; 
	    Client clientOne = new Client();
	    
	    try{
	    	t=session.beginTransaction();
	    		
	    	if(type.equals(ClientType.CLIENTBASIC))
	    	{
	    		ClientBasic clientBasic = new ClientBasic();
	    		
	    		clientOne.setFirstName(client.getClientFirstName());    	
	    		clientOne.setLastName(client.getClientLastName());
	    		clientOne.setEmail(client.getClientEmail());  
	    		
	    		session.persist(clientOne);
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
	
	    	t.commit();
	    }
	   catch (HibernateException e) {
	         if (t!=null) t.rollback();
	         e.printStackTrace(); 
	   }
	   finally{
		   session.close(); 
	   }
       return true;
    }
    /* Client Basic End */
    
    public static List<ClientLead> getLeads(){
    	/*Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");*/
    	
//    	SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
//    	Session session = factory.openSession();
    	
//    	Transaction transaction=session.beginTransaction();  
//    	
//    	Query query=session.createQuery("FROM ClientLead");
    
    /*	@SuppressWarnings("unchecked")
		List<ClientLead> list = query.list();  	
    	
    	transaction.commit();
    	session.close();*/
    	
    	return null;    	
    }
    
  
    
    public static List<ClientOpportunity> getOportunities(){
    /*	Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");*/
    	
//    	SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
//    	Session session = factory.openSession();
//    	
//    	Transaction transaction=session.beginTransaction();  
//    	
//    	Query query=session.createQuery("FROM ClientOpportunity");
//    
//    	@SuppressWarnings("unchecked")
//		List<ClientOpportunity> list = query.list();  	
//    	
//    	transaction.commit();
//    	session.close();
    	
    	return null;   
    }
    


   
}