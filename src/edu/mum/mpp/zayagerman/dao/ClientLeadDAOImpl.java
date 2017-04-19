package edu.mum.mpp.zayagerman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.mum.mpp.zayagerman.entity.ClientLead;
import edu.mum.mpp.zayagerman.service.ClientLeadDAO;
import edu.mum.mpp.zayagerman.settings.DBUtil;

public class ClientLeadDAOImpl implements ClientLeadDAO{
	private Connection conn;
	
    public ClientLeadDAOImpl() {
        conn = DBUtil.getConnection();
    }
    
	@Override
	public void addClientLead(ClientLead clientLead) {
		  try {
	            String query = "insert into client_lead (id, source, status, amount, industry, description) values (?,?,?,?,?,?)";
	           
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            
	            preparedStatement.setInt(1, clientLead.getId());
	            preparedStatement.setString(2, clientLead.getSource());
	            preparedStatement.setString(3, clientLead.getStatus());
	            preparedStatement.setDouble(4, clientLead.getAmount());
	            preparedStatement.setString(5, clientLead.getIndustry());
	            preparedStatement.setString(6, clientLead.getDescription());
	            
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("New ClientLead Record Addded: " + clientLead.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void deleteClientLead(int clientLeadId) {
		try {
            String query = "delete from client_lead where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, clientLeadId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            System.out.println("Client Lead Record Deleted: " + clientLeadId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void updateClientLead(ClientLead clientLead) {
		 try {			
	            String query = "update activity set source=?, status=?, amount=?, industry=?, description=? where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            
	            preparedStatement.setString(1, clientLead.getSource());
	            preparedStatement.setString(2, clientLead.getStatus());
	            preparedStatement.setDouble(3, clientLead.getAmount());
	            preparedStatement.setString(4, clientLead.getIndustry());
	            preparedStatement.setString(5, clientLead.getDescription());
	            preparedStatement.setInt(6, clientLead.getId());
	            preparedStatement.executeUpdate();
	            
	            preparedStatement.close();
	            
	            System.out.println("Client Lead Record Updated: " + clientLead.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<ClientLead> getAllClientLeads() {
		List<ClientLead> clientLeadList = new ArrayList<ClientLead>();
        try {
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from client_lead l left join client c on l.id_client = c.id");
            
            while( resultSet.next() ) {
            	ClientLead clientLead = new ClientLead();
                     	
            	clientLead.setId(resultSet.getInt("id"));
            	clientLead.setAmount(resultSet.getDouble("amount"));
            	clientLead.setDescription(resultSet.getString("description"));
            	clientLead.setIndustry(resultSet.getString("industry"));
            	clientLead.setSource(resultSet.getString("source"));
            	clientLead.setStatus(resultSet.getString("status"));
            	clientLead.setId(resultSet.getInt("id_client"));
            	clientLead.setFirstName(resultSet.getString("fistname"));
            	clientLead.setLastName(resultSet.getString("lastname"));
            	clientLead.setEmail(resultSet.getString("email"));
            	
            	
            	clientLeadList.add(clientLead);
            	
            	System.out.println("New Activity Record: " + clientLead.toString());
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientLeadList;
	}

	@Override
	public ClientLead getClientLeadById(int clientLeadId) {
		ClientLead clientLead = new ClientLead();
        try {
        	
        	StringBuilder queryBuilder = new StringBuilder();
        	queryBuilder.append("select * from client_lead ");
        	queryBuilder.append("where id=?");
        	
            PreparedStatement preparedStatement = conn.prepareStatement(queryBuilder.toString());
            preparedStatement.setInt(1, clientLeadId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

            	clientLead.setId(resultSet.getInt("id"));
            	clientLead.setAmount(resultSet.getDouble("amount"));
            	clientLead.setDescription(resultSet.getString("description"));
            	clientLead.setIndustry(resultSet.getString("industry"));
            	clientLead.setSource(resultSet.getString("source"));
            	clientLead.setStatus(resultSet.getString("status"));
            	
            	System.out.println("New Activity Record: " + clientLead.toString());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientLead;
	}

}
