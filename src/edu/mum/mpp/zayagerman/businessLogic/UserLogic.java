package edu.mum.mpp.zayagerman.businessLogic;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import edu.mum.mpp.zayagerman.user.User;

public class UserLogic {
	
	public static boolean resetPassword(int id, String password)
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	String sql = "UPDATE User u SET i.password :password WHERE i.id :id";
    	
    	Query query = session.createQuery(sql);
    	
    	query.setParameter("id", id);
    	query.setParameter("password", password);
    	
    	query.executeUpdate();
    	    	
    	transaction.commit();
    	session.close();
    	    	
    	return true;
	}
	
	public static boolean createUser(User user)
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	session.persist(user);
    	    	
    	transaction.commit();
    	session.close();
    	    	
    	return true;
	}
	
	public static User getUser(int id)
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	User user = (User) session.get(User.class, id);
    	    	
    	transaction.commit();
    	session.close();
    	
    	return user;
	}
	
	public static List<User> getUserList()
	{
		Configuration config = new Configuration();
    	config.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory = config.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction transaction=session.beginTransaction();  
    	
    	Query query = session.createQuery("FROM User");
    	
    	@SuppressWarnings("unchecked")
		List<User> list = query.list();    
    	    	
    	transaction.commit();
    	session.close();
    	
    	return list;
	}
}
