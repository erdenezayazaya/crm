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
import edu.mum.mpp.zayagerman.entity.Company;
import edu.mum.mpp.zayagerman.service.CompanyDAO;
import edu.mum.mpp.zayagerman.settings.DBUtil;

public class CompanyDAOImpl implements CompanyDAO{
	private Connection conn;
	
    public CompanyDAOImpl() {
        conn = DBUtil.getConnection();
    }	
	
	@Override
	public void addCompany(Company company) {
		 try {
	            String query = "insert into company(name, type) values (?,?)";
	            
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            
	            preparedStatement.setString(1, company.getName());
	            preparedStatement.setString(2, company.getType());
	  
	            preparedStatement.executeUpdate();
	            
	            preparedStatement.close();
	            
	            System.out.println("New Company Record Addded: " + company.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void deleteCompany(int companyId) {
		 try {
	            String query = "delete from company where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setInt(1, companyId);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Company Record Deleted: " + companyId);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void updateCompany(Company company) {
		 try {			
	            String query = "update company set name=?, type=? where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            
	            preparedStatement.setString(1, company.getName());
	            preparedStatement.setString(2, company.getType());
	 
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Company Record Updated: " + company.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Company> getAllCompanys() {
		 List<Company> companyList = new ArrayList<Company>();
	        try {
	            Statement statement = conn.createStatement();
	 
	            ResultSet resultSet = statement.executeQuery("select * from company");
	            
	            while( resultSet.next() ) {
	            	Company company = new Company();
	            	
	            	company.setName(resultSet.getString("name"));
	            	company.setType(resultSet.getString("type"));

	                System.out.println("New Company Record: " + company.toString());
	            	
	                companyList.add(company);
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return companyList;
	}

	@Override
	public Company getCompanyById(int companyId) {
		Company company = new Company();
        try {
        	
        	StringBuilder queryBuilder = new StringBuilder();
        	queryBuilder.append("select name, type ");
        	queryBuilder.append("from company ");
        	queryBuilder.append("where id=?");
        	
            PreparedStatement preparedStatement = conn.prepareStatement(queryBuilder.toString());
            preparedStatement.setInt(1, companyId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            	company.setName(resultSet.getString("name"));
            	company.setType(resultSet.getString("type"));
  
            	System.out.println("New Company Record: " + company.toString());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
	}

}
