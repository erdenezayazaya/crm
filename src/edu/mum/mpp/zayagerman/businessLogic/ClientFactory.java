package edu.mum.mpp.zayagerman.businessLogic;

import java.util.List;


import edu.mum.mpp.zayagerman.entity.ClientBasic;
import edu.mum.mpp.zayagerman.entity.ClientData;
import edu.mum.mpp.zayagerman.entity.ClientLead;
import edu.mum.mpp.zayagerman.entity.ClientOpportunity;
import edu.mum.mpp.zayagerman.settings.ClientType;

public class ClientFactory {
	
    public ClientFactory() {
    	super();
    }
    
//    /* Client Basic */
//    
//    public static ClientBasic getClientBasic(int id)
//    {
//	   Session session=new Configuration().configure("hibernate.cfg.xml")  
//                  .buildSessionFactory().openSession();  
//	   
//	   Transaction t=null; 
//	   
//	   try{
//		   t=session.beginTransaction();
//		   
//		   ClientBasic clientBasic = (ClientBasic) session.get(ClientBasic.class, id);
//		   
//		   t.commit();
//		   
//		   return clientBasic;
//	   }
//	   catch (HibernateException e) {
//	         if (t!=null) t.rollback();
//	         e.printStackTrace(); 
//	   }
//	   finally{
//         session.close(); 
//	   }
//	   
//	   return null;
//    }
//    
//    public static List<ClientBasic> getClientBasics()
//    {
//	   Session session=new Configuration().configure("hibernate.cfg.xml")  
//                 .buildSessionFactory().openSession();  
//	   
//	   Transaction t=null; 
//	   
//	   try{
//		   t=session.beginTransaction();
//		   
//		//   Query query=session.createQuery("FROM ClientBasic");
//		//   @SuppressWarnings("unchecked")
//		 //  List<ClientBasic> list = query.list();  
//		   
//		 //  t.commit();
//		   
//		   return null;
//	   }
//	   catch (HibernateException e) {
//	         if (t!=null) t.rollback();
//	         e.printStackTrace(); 
//	   }
//	   finally{
//        session.close(); 
//	   }
//	   
//	   return null;    
//    }
//    
//    public static void deleteClientBasic(int id)
//    {
//    	Session session=new Configuration().configure("hibernate.cfg.xml")  
//                .buildSessionFactory().openSession();  
//	   
//	    Transaction t=null; 
//	    
//	    try{
//	    	t=session.beginTransaction();
//	    	
//	    	ClientBasic clientBasic = (ClientBasic) session.get(ClientBasic.class, id);
//	    	session.delete(clientBasic);
//	    	t.commit();
//	    }
//	   catch (HibernateException e) {
//	         if (t!=null) t.rollback();
//	         e.printStackTrace(); 
//	   }
//	   finally{
//      session.close(); 
//	   }
//    }
//    
//    public static void updateClientBasic(int id, ClientBasic client)
//    {
//    	Session session=new Configuration().configure("hibernate.cfg.xml")  
//                .buildSessionFactory().openSession();  
//	   
//	    Transaction t=null; 
//	    
//	    try{
//	    	t=session.beginTransaction();
//	    	
//	    	ClientBasic clientBasic = (ClientBasic) session.get(ClientBasic.class, id);
//	    	session.update(clientBasic);
//	    	t.commit();
//	    }
//	   catch (HibernateException e) {
//	         if (t!=null) t.rollback();
//	         e.printStackTrace(); 
//	   }
//	   finally{
//      session.close(); 
//	   }
//    }
//    
//    public static boolean createClient(ClientType type, ClientData client) {
//    	
//    	
//    	
//    }
    
    
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