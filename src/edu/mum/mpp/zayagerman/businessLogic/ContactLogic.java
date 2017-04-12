package edu.mum.mpp.zayagerman.businessLogic;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import edu.mum.mpp.zayagerman.contact.Contact;

public class ContactLogic {
	public static boolean createContact(Contact contact)
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	session.persist(contact);
    	    	
    	transaction.commit();
    	session.close();
    	    	
    	return true;
	}
	
	public static Contact getContact(int id)
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	Contact contact = (Contact) session.get(Contact.class, id);
    	    	
    	transaction.commit();
    	session.close();
    	
    	return contact;
	}
	
	public static List<Contact> getActivityContact()
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	Query query = session.createQuery("FROM Contact");
    	
    	@SuppressWarnings("unchecked")
		List<Contact> list = query.list();    
    	    	
    	transaction.commit();
    	session.close();
    	
    	return list;
	}
}
