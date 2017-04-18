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
import edu.mum.mpp.zayagerman.entity.Sale;
import edu.mum.mpp.zayagerman.service.SaleDAO;
import edu.mum.mpp.zayagerman.settings.DBUtil;

public class SaleDAOImpl implements SaleDAO{
	private Connection conn;
	
    public SaleDAOImpl() {
        conn = DBUtil.getConnection();
    }

	@Override
	public void addSale(Sale sale) {
		  try {
	            String query = "insert into activity (id, typeSale, amount, percentGain, amountGain, dateSale, client_id) values (?,?,?,?,?,?,?)";
	         
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            
	            preparedStatement.setInt(1, sale.getIdSale());
	            preparedStatement.setString(1, sale.getTypeSale());
	            preparedStatement.setDouble(1, sale.getAmount());
	            preparedStatement.setDouble(1, sale.getPercentGain());
	            preparedStatement.setDouble(1, sale.getAmountGain());
	            preparedStatement.setDate(1, sale.getDateSale());
	            preparedStatement.setInt(1, sale.getClient().getId());
	            
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("New Sale Record Addded: " + sale.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void deleteSale(int saleId) {
		 try {
	            String query = "delete from sale where id=?";
	            
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	       
	            preparedStatement.setInt(1, saleId);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Sale Record Deleted: " + saleId);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void updateSale(Sale sale) {
		 try {	
	            String query = "update activity set typeSale=?, amount=?, percentGain=?, amountGain=?, dateSale=?, client_id=? where id=?";
	            
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            
	            preparedStatement.setString(1, sale.getTypeSale());
	            preparedStatement.setDouble(2, sale.getAmount());
	            preparedStatement.setDouble(3, sale.getPercentGain());
	            preparedStatement.setDouble(4, sale.getAmount());
	            preparedStatement.setDate(5, sale.getDateSale());
	            preparedStatement.setInt(6, sale.getClient().getId());
	            preparedStatement.setInt(7, sale.getIdSale());
	            
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Sale Record Updated: " + sale.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Sale> getAllSales() {
		 List<Sale> saleList = new ArrayList<Sale>();
	        try {
	            Statement statement = conn.createStatement();
	            
	        	StringBuilder queryBuilder = new StringBuilder();
	           	queryBuilder.append("select c.id, c.firstname, c.lastName, c.email, s.id, s.typeSale, ");
	        	queryBuilder.append("s.amount, s.percentGain, s.amountGain, s.dateSale, s.client_id ");
	        	queryBuilder.append("from sale s ");
	        	queryBuilder.append("inner join client c on s.client_id = c.id ");
	 
	            ResultSet resultSet = statement.executeQuery(queryBuilder.toString());
	            
	            while( resultSet.next() ) {
	            	Sale sale = new Sale();
	            
	            	Client client = new Client();
	            	
	            	client.setId(resultSet.getInt("id"));
	            	client.setFirstName(resultSet.getString("firstname"));
	            	client.setLastName(resultSet.getString("lastName"));
	            	client.setEmail(resultSet.getString("email"));
	            	
	            	sale.setClient(client);
	            	
	            	sale.setIdSale(resultSet.getInt("s.id"));
	            	sale.setAmount(resultSet.getDouble("s.amount"));
	            	sale.setAmountGain(resultSet.getDouble("s.amountGain"));            	
	            	sale.setDateSale(resultSet.getDate("dateSale"));
	            	sale.setPercentGain(resultSet.getDouble("percentGain"));
	            	sale.setTypeSale(resultSet.getString("typeSale"));	            	
	            	
	                System.out.println("New Activity Record: " + sale.toString());
	            	
	                saleList.add(sale);
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return saleList;
	}

	@Override
	public Sale getSaleById(int saleId) {
		
		Sale sale = new Sale();
        try {
        	
        	StringBuilder queryBuilder = new StringBuilder();
        	queryBuilder.append("select c.id, c.firstname, c.lastName, c.email, s.id, s.typeSale, ");
        	queryBuilder.append("s.amount, s.percentGain, s.amountGain, s.dateSale, s.client_id ");
        	queryBuilder.append("from sale s ");
        	queryBuilder.append("inner join client c on s.client_id = c.id ");
        	queryBuilder.append("where s.id=?");
        	
            PreparedStatement preparedStatement = conn.prepareStatement(queryBuilder.toString());
            preparedStatement.setInt(1, saleId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
      
            	Client client = new Client();
            	
            	client.setId(resultSet.getInt("c.id"));
            	client.setFirstName(resultSet.getString("c.firstname"));
            	client.setLastName(resultSet.getString("c.lastName"));
            	client.setEmail(resultSet.getString("c.email"));
            	
            	sale.setClient(client);
            	
            	sale.setIdSale(resultSet.getInt("s.id"));
            	sale.setAmount(resultSet.getDouble("s.amount"));
            	sale.setAmountGain(resultSet.getDouble("s.amountGain"));            	
            	sale.setDateSale(resultSet.getDate("dateSale"));
            	sale.setPercentGain(resultSet.getDouble("percentGain"));
            	sale.setTypeSale(resultSet.getString("typeSale"));
            	
            	System.out.println("New Sale Record: " + sale.toString());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sale;
	}
	
}
