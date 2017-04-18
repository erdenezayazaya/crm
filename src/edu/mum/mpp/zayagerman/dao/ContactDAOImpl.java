package edu.mum.mpp.zayagerman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.mum.mpp.zayagerman.entity.Activity;
import edu.mum.mpp.zayagerman.entity.Client;
import edu.mum.mpp.zayagerman.entity.Contact;
import edu.mum.mpp.zayagerman.service.ContactDAO;
import edu.mum.mpp.zayagerman.settings.DBUtil;

public class ContactDAOImpl implements ContactDAO{
	private Connection conn;
	
    public ContactDAOImpl() {
        conn = DBUtil.getConnection();
    }

	@Override
	public void addContact(Contact contact) {
		try {
            String query = "insert into activity (industry_id, company_id) values (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
           
            preparedStatement.setInt(1, contact.getIndustry().getId());
            preparedStatement.setInt(2, contact.getCompany().getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            System.out.println("New Contact Record Addded: " + contact.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteContact(int contactId) {
		 try {
	            String query = "delete from contact where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setInt(1, contactId);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Contact Record Deleted: " + contactId);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void updateContact(Contact contact) {
		 try {			
	            String query = "update activity set industry_id=?, company_id=? where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	           
	            preparedStatement.setInt(1, contact.getIndustry().getId());
	            preparedStatement.setInt(2, contact.getCompany().getId());
	            preparedStatement.setInt(3, contact.getId());

	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Contact Record Updated: " + contact.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Contact> getAllContacts() {
		 List<Contact> contactList = new ArrayList<Contact>();
	        try {
	            Statement statement = conn.createStatement();
	            
	        	StringBuilder queryBuilder = new StringBuilder();
	        	queryBuilder.append("select id, industry_id, company_id ");
	        	queryBuilder.append("from contact");
	        	queryBuilder.append("where id=?");
	        		 
	            ResultSet resultSet = statement.executeQuery(queryBuilder.toString());
	            
	            while( resultSet.next() ) {
	            	Contact contact = new Contact();

	            	contact.setId(resultSet.getInt("id"));
	            	
	                System.out.println("New Contact Record: " + contact.toString());
	            	
	                contactList.add(contact);
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return contactList;
	}

	@Override
	public Contact getContactById(int contactId) {
		Contact contact = new Contact();
        try {
        	
        	StringBuilder queryBuilder = new StringBuilder();
        	queryBuilder.append("select id, industry_id, company_id ");
        	queryBuilder.append("from contact");
        	queryBuilder.append("where id=?");
        	
            PreparedStatement preparedStatement = conn.prepareStatement(queryBuilder.toString());
            preparedStatement.setInt(1, contactId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            	
            	contact.setId(resultSet.getInt("id"));
            	
            	System.out.println("New Contact Record: " + contact.toString());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
	}

}
