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
import edu.mum.mpp.zayagerman.entity.Industry;
import edu.mum.mpp.zayagerman.service.IndustryDAO;
import edu.mum.mpp.zayagerman.settings.DBUtil;

public class IndustryDAOImpl implements IndustryDAO{
	private Connection conn;
	
    public IndustryDAOImpl() {
        conn = DBUtil.getConnection();
    }
	
	@Override
	public void addIndustry(Industry industry) {
		   try {
	            String query = "insert into industry (name, state) values (?,?)";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            
	            preparedStatement.setString(1, industry.getName());
	            preparedStatement.setString(2, industry.getState());

	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("New Industry Record Addded: " + industry.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void deleteIndustry(int industryId) {
		 try {
	            String query = "delete from industry where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setInt(1, industryId);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Industry Record Deleted: " + industryId);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void updateIndustry(Industry industry) {
		 try {			
	            String query = "update industry set name=?, state=? where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            
	            preparedStatement.setString(1, industry.getName());
	            preparedStatement.setString(2, industry.getState());
	 
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Industry Record Updated: " + industry.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Industry> getAllIndustrys() {
		List<Industry> industryList = new ArrayList<Industry>();
        try {
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from industry");
            
            while( resultSet.next() ) {
            	Industry industry = new Industry();
            	
            	industry.setId(resultSet.getInt("id"));
            	industry.setName(resultSet.getString("name"));
            	industry.setState(resultSet.getString("state"));  
            	
                System.out.println("New Industry Record: " + industry.toString());
            	
                industryList.add(industry);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return industryList;
	}

	@Override
	public Industry getIndustryById(int IndustryId) {
		Industry industry = new Industry();
        try {
        	
        	StringBuilder queryBuilder = new StringBuilder();
        	
        	queryBuilder.append("select id, name, state, ");
        	queryBuilder.append("from activity ");
        	queryBuilder.append("where id=?");
        	
            PreparedStatement preparedStatement = conn.prepareStatement(queryBuilder.toString());
            preparedStatement.setInt(1, IndustryId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
              	
            	industry.setId(resultSet.getInt("id"));
            	industry.setName(resultSet.getString("name"));
            	industry.setState(resultSet.getString("state"));    
            	
            	System.out.println("New Industry Record: " + industry.toString());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return industry;
	}
	
}
