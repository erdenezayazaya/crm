package edu.mum.mpp.zayagerman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.mum.mpp.zayagerman.entity.Activity;
import edu.mum.mpp.zayagerman.entity.Address;
import edu.mum.mpp.zayagerman.entity.Client;
import edu.mum.mpp.zayagerman.service.AddressDAO;
import edu.mum.mpp.zayagerman.settings.DBUtil;

public class AddressDAOImpl implements AddressDAO{
	private Connection conn;
	
    public AddressDAOImpl() {
        conn = DBUtil.getConnection();
    }

	@Override
	public void addAddress(Address address) {
		try {
            String query = "insert into address (id, address, phone, city, zipcode, country, client_id) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, address.getId());
            preparedStatement.setString(2, address.getAddress());
            preparedStatement.setString(3, address.getPhone());
            preparedStatement.setString(4,  address.getCity());
            preparedStatement.setInt(5, address.getZipCode());
            preparedStatement.setString(6, address.getCountry());
            preparedStatement.setInt(7, address.getClient().getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            System.out.println("New Address Record Addded: " + address.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteAddress(int addressId) {
		 try {
	            String query = "delete from address where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setInt(1, addressId);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Address Record Deleted: " + addressId);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void updateAddress(Address address) {
		 try {			
	            String query = "update address set address=?, phone=?, city=?, zipcode=?, country=? where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setString(1, address.getAddress());
	            preparedStatement.setString(2, address.getPhone());
	            preparedStatement.setString(3, address.getCity());
	            preparedStatement.setInt(4, address.getZipCode());
	            preparedStatement.setString(5, address.getCountry());
	            preparedStatement.setInt(6, address.getId());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Address Record Updated: " + address.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Address> getAllAddresss() {
		 List<Address> addressList = new ArrayList<Address>();
	        try {
	            Statement statement = conn.createStatement();
	            
	            StringBuilder queryBuilder = new StringBuilder();
	        	queryBuilder.append("select c.id, c.firstname, c.lastName, c.email, a.id, a.address, a.phone, a.city, a.zipcode, ");
	        	queryBuilder.append("a.country from address a ");
	        	queryBuilder.append("inner join client c on a.client_id = c.id ");
	        	queryBuilder.append("where c.id=?");
	 
	            ResultSet resultSet = statement.executeQuery(queryBuilder.toString());
	            
	            while( resultSet.next() ) {
	            	Address address = new Address();
	            
	             	Client client = new Client();
	            	
	            	client.setId(resultSet.getInt("c.id"));
	            	client.setFirstName(resultSet.getString("c.firstname"));
	            	client.setLastName(resultSet.getString("c.lastName"));
	            	client.setEmail(resultSet.getString("c.email"));
	            	
	            	address.setClient(client);
	            	
	            	address.setAddress(resultSet.getString("a.address"));
	            	address.setCity(resultSet.getString("a.city"));
	            	address.setCountry(resultSet.getString("a.country"));
	            	address.setId(resultSet.getInt("a.id"));
	            	address.setPhone(resultSet.getString("a.phone"));
	            	address.setState(resultSet.getString("a.state"));
	            	address.setZipCode(resultSet.getInt("a.zipcode"));
	            	
	            	System.out.println("New Address Record: " + address.toString());
	            	
	                addressList.add(address);
	                
	                System.out.println("New Activity Record: " + address.toString());
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return addressList;
	}

	@Override
	public Address getAddressById(int addressId) {
		Address address = new Address();
        try {
         	
        	StringBuilder queryBuilder = new StringBuilder();
        	queryBuilder.append("select c.id, c.firstname, c.lastName, c.email, a.id, a.address, a.phone, a.city, a.zipcode, ");
        	queryBuilder.append("a.country from address a ");
        	queryBuilder.append("inner join client c on a.client_id = c.id ");
        	queryBuilder.append("where c.id=?");
        	
            PreparedStatement preparedStatement = conn.prepareStatement(queryBuilder.toString());
            preparedStatement.setInt(1, addressId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
      
            	Client client = new Client();
            	
            	client.setId(resultSet.getInt("c.id"));
            	client.setFirstName(resultSet.getString("c.firstname"));
            	client.setLastName(resultSet.getString("c.lastName"));
            	client.setEmail(resultSet.getString("c.email"));
            	
            	address.setClient(client);
            	
            	address.setAddress(resultSet.getString("a.address"));
            	address.setCity(resultSet.getString("a.city"));
            	address.setCountry(resultSet.getString("a.country"));
            	address.setId(resultSet.getInt("a.id"));
            	address.setPhone(resultSet.getString("a.phone"));
            	address.setState(resultSet.getString("a.state"));
            	address.setZipCode(resultSet.getInt("a.zipcode"));
            	
            	System.out.println("New Address Record: " + address.toString());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
	}

}
