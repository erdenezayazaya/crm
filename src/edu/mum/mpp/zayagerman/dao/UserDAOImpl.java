package edu.mum.mpp.zayagerman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.mum.mpp.zayagerman.entity.User;
import edu.mum.mpp.zayagerman.service.UserDAO;
import edu.mum.mpp.zayagerman.settings.DBUtil;

public class UserDAOImpl implements UserDAO{
	private Connection conn;
	
    public UserDAOImpl() {
        conn = DBUtil.getConnection();
    }
    
	@Override
	public void addUser(User user) {
		  try {
	            String query = "insert into user(loginName, name, password, accessLevel, lastVisited) values (?,?,?,?,?)";
	           
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setString(1, user.getLoginName());
	            preparedStatement.setString(2, user.getName());
	            preparedStatement.setString(3, user.getPassword());
	            preparedStatement.setString(4, user.getAccessLevel());
	            preparedStatement.setDate(5, user.getLastVisited());
	            
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("New User Record Addded: " + user.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void deleteUser(int usertId) {
		 try {
	            String query = "delete from user where id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setInt(1, usertId);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("User Record Deleted: " + usertId);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void updateUser(User user) {
		 try {			
	            String query = "update user set loginName=?, name=?, password=?, accessLevel=?, lastVisited=? where id=?";
	            
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setString(1, user.getLoginName());
	            preparedStatement.setString(2, user.getName());
	            preparedStatement.setString(3, user.getPassword());
	            preparedStatement.setString(4, user.getAccessLevel());
	            preparedStatement.setDate(5, user.getLastVisited());
	            preparedStatement.setInt(6, user.getId());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("User Record Updated: " + user.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<User> getAllUsers() {
		 List<User> userList = new ArrayList<User>();
	        try {
	        	Statement statement = conn.createStatement();
	            ResultSet resultSet = statement.executeQuery("select * from User");
	            
	            while( resultSet.next() ) {
	            	User user = new User();
	            
	            	user.setId(resultSet.getInt("id"));
	            	user.setLoginName(resultSet.getString("loginName"));
	            	user.setName(resultSet.getString("name"));
	            	user.setPassword(resultSet.getString("password"));
	            	user.setAccessLevel(resultSet.getString("accessLevel"));
	            	user.setLastVisited(resultSet.getDate("lastVisited"));
	            	
	                
	                System.out.println("New Activity Record: " + user.toString());
	            	
	            	userList.add(user);
	
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return userList;
	}

	@Override
	public User getUserById(int userId) {
		User user = new User();
        try {
        	
        	StringBuilder queryBuilder = new StringBuilder();
        	queryBuilder.append("select * from User ");
        	queryBuilder.append("where id=?");
        	
            PreparedStatement preparedStatement = conn.prepareStatement(queryBuilder.toString());
            preparedStatement.setInt(1, userId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            	
            	user.setId(resultSet.getInt("id"));
            	user.setLoginName(resultSet.getString("loginName"));
            	user.setName(resultSet.getString("name"));
            	user.setPassword(resultSet.getString("password"));
            	user.setAccessLevel(resultSet.getString("accessLevel"));
            	user.setLastVisited(resultSet.getDate("lastVisited"));
            	
            	System.out.println("New User Record: " + user.toString());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
	}

}
