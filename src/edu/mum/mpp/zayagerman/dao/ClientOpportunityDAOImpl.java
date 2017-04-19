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
import edu.mum.mpp.zayagerman.entity.ClientOpportunity;
import edu.mum.mpp.zayagerman.service.ClientOpportunityDAO;
import edu.mum.mpp.zayagerman.settings.DBUtil;

public class ClientOpportunityDAOImpl implements ClientOpportunityDAO{
	private Connection conn;
	
    public ClientOpportunityDAOImpl() {
        conn = DBUtil.getConnection();
    }

	@Override
	public void addClientOpportunity(ClientOpportunity clientOpportunity) {
		 try {
	            String query = "insert into client_opportunity (id, amount, probability, "
	            		+ "closedDate, description) values (?,?,?,?,?)";
	            
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            
	            preparedStatement.setInt(1, clientOpportunity.getId());
	            preparedStatement.setDouble(2, clientOpportunity.getAmount());
	            preparedStatement.setInt(3, clientOpportunity.getProbability());
	            preparedStatement.setDate(4, clientOpportunity.getCloseDate());
	            preparedStatement.setString(5, clientOpportunity.getDescription());
	            preparedStatement.executeUpdate();
	            
	            preparedStatement.close();
	            
	            System.out.println("New Client Opportunity Record Addded: " + clientOpportunity.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void deleteClientOpportunity(int clientOpportunityId) {
		 try {
	            String query = "delete from client_opportunity where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setInt(1, clientOpportunityId);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Client opportunity Record Deleted: " + clientOpportunityId);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void updateClientOpportunity(ClientOpportunity clientOpportunity) {
		 try {			
	            String query = "update client_opportunity set amount=?, probability=?, "
	            		+ "closedDate=?, description=? where id=?";
	            
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	        
	            preparedStatement.setDouble(1, clientOpportunity.getAmount());
	            preparedStatement.setDouble(2, clientOpportunity.getProbability());
	            preparedStatement.setDate(3, clientOpportunity.getCloseDate());
	            preparedStatement.setString(4, clientOpportunity.getDescription());
	            preparedStatement.setInt(5, clientOpportunity.getId());
	            
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Client Opportunity Record Updated: " + clientOpportunity.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<ClientOpportunity> getAllClientOpportunitys() {
		List<ClientOpportunity> clientOpportunityList = new ArrayList<ClientOpportunity>();
        try {
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from client_opportunity");
            
            while( resultSet.next() ) {
            	ClientOpportunity clientOpportunity = new ClientOpportunity();
            	
            	clientOpportunity.setId(resultSet.getInt("id"));
            	clientOpportunity.setAmount(resultSet.getDouble("amount"));
            	clientOpportunity.setProbability(resultSet.getInt("probability"));
            	clientOpportunity.setCloseDate(resultSet.getDate("closedDate"));
            	clientOpportunity.setDescription(resultSet.getString("description"));
            	
                System.out.println("New Client Opportunity Record: " + clientOpportunity.toString());
            	
                clientOpportunityList.add(clientOpportunity);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientOpportunityList;
	}

	@Override
	public ClientOpportunity getClientOpportunityById(int clientOpportunityId) {
		ClientOpportunity clientOpportunity = new ClientOpportunity();
        try {
        	
        	StringBuilder queryBuilder = new StringBuilder();
        	queryBuilder.append("select * from client_opportunity ");
        	queryBuilder.append("where id=?");
        	
            PreparedStatement preparedStatement = conn.prepareStatement(queryBuilder.toString());
            preparedStatement.setInt(1, clientOpportunityId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
   
            	clientOpportunity.setId(resultSet.getInt("id"));
            	clientOpportunity.setAmount(resultSet.getDouble("amount"));
            	clientOpportunity.setProbability(resultSet.getInt("probability"));
            	clientOpportunity.setCloseDate(resultSet.getDate("closedDate"));
            	clientOpportunity.setDescription(resultSet.getString("description"));
            	
            	System.out.println("New ClientOpportunity Record: " + clientOpportunity.toString());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientOpportunity;
	}
	
}