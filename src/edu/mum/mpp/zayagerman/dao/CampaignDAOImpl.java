package edu.mum.mpp.zayagerman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.mum.mpp.zayagerman.entity.Activity;
import edu.mum.mpp.zayagerman.entity.Campaign;
import edu.mum.mpp.zayagerman.entity.Client;
import edu.mum.mpp.zayagerman.service.CampaignDAO;
import edu.mum.mpp.zayagerman.settings.DBUtil;

public class CampaignDAOImpl implements CampaignDAO{
	private Connection conn;
	
    public CampaignDAOImpl() {
        conn = DBUtil.getConnection();
    }

	@Override
	public void addCampaign(Campaign campaign) {
		 try {
	            String query = "insert into campaign (name, details, state, date) values (?,?,?,?,?,?)";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            
	            preparedStatement.setString(1, campaign.getName());
	            preparedStatement.setString(2, campaign.getDetails());
	            preparedStatement.setInt(3, campaign.isState());
	            preparedStatement.setDate(4, campaign.getDate());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("New Campaign Record Addded: " + campaign.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void deleteCampaign(int campaignId) {
		 try {
	            String query = "delete from campaign where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setInt(1, campaignId);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Campaign Record Deleted: " + campaignId);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void updateCampaign(Campaign campaign) {
		 try {			
	            String query = "update campaign set name=?, details=?, state=?, date=? where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	              
	            preparedStatement.setString(1, campaign.getName());
	            preparedStatement.setString(2, campaign.getDetails());
	            preparedStatement.setInt(3, campaign.isState());
	            preparedStatement.setDate(4, campaign.getDate());
	            preparedStatement.setInt(5, campaign.getId());
	            
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Campaign Record Updated: " + campaign.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Campaign> getAllCampaigns() {
		 List<Campaign> campaignList = new ArrayList<Campaign>();
	        try {
	            Statement statement = conn.createStatement();
	 
	            ResultSet resultSet = statement.executeQuery("select * from campaign");
	            
	            while( resultSet.next() ) {
	            	Campaign campaign = new Campaign();
	            	
	            	campaign.setDate(resultSet.getDate("date"));
	            	campaign.setDetails(resultSet.getString("details"));
	            	campaign.setId(resultSet.getInt("id"));
	            	campaign.setName(resultSet.getString("name"));
	            	campaign.setState(resultSet.getInt("state"));
	            	
	            	System.out.println("New Campaign Record: " + campaign.toString());
	            		          	            	
	            	campaignList.add(campaign);
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return campaignList;
	}

	@Override
	public Campaign getCampaignById(int campaignId) {
		Campaign campaign = new Campaign();
        try {
        	
        	StringBuilder queryBuilder = new StringBuilder();
        	queryBuilder.append("select * from campaign ");
        	queryBuilder.append("where id=?");
        	
            PreparedStatement preparedStatement = conn.prepareStatement(queryBuilder.toString());
            preparedStatement.setInt(1, campaignId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            	
            	campaign.setDate(resultSet.getDate("date"));
            	campaign.setDetails(resultSet.getString("details"));
            	campaign.setId(resultSet.getInt("id"));
            	campaign.setName(resultSet.getString("name"));
            	campaign.setState(resultSet.getInt("state"));
            	
            	System.out.println("New Campaign Record: " + campaign.toString());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return campaign;
	}
	
}
