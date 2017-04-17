package edu.mum.mpp.zayagerman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.mum.mpp.zayagerman.entity.Activity;
import edu.mum.mpp.zayagerman.settings.DBUtil;

public class ActivityController implements {	
	private Connection conn;
	
    public ActivityController() {
        conn = DBUtil.getConnection();
    }

	@Override
	public void addActivity(Activity activity) {
	    try {
            String query = "insert into activity (type, dateBegin, dateClosed, durationHours, state, client_id) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString(1, activity.getType());
            preparedStatement.setDate(2, activity.getDateBegin());
            preparedStatement.setDate(3, activity.getDateClosed());
            preparedStatement.setInt(4, activity.getDurationHours());
            preparedStatement.setString(5, activity.getState());
            preparedStatement.setInt(6, activity.getClientBasic().getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            System.out.println("New Activity Record Addded: " + activity.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteActivity(int activityId) {
		 try {
	            String query = "delete from activity where idactivity=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setInt(1, activityId);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Activity Record Deleted: " + activityId);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void updateActivity(Activity activity) {
		 try {			
	            String query = "update student set type=?, dateBegin=?, dateClosed=?, durationHours=?, state=? where idactivity=?";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setString(1, activity.getType());
	            preparedStatement.setDate(2, activity.getDateBegin());
	            preparedStatement.setDate(3, activity.getDateClosed());
	            preparedStatement.setInt(4, activity.getDurationHours());
	            preparedStatement.setString(5, activity.getState());
	            preparedStatement.setInt(6, activity.getId());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            System.out.println("Activity Record Updated: " + activity.toString());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Activity> getAllActivitys() {
		 List<Activity> activityList = new ArrayList<Activity>();
	        try {
	            Statement statement = conn.createStatement();
	            ResultSet resultSet = statement.executeQuery( "select * from activity" );
	            while( resultSet.next() ) {
	            	Activity activity = new Activity();
	            	activity.set	                
	                
	                student.setStudentId( resultSet.getInt( "studentId" ) );
	                student.setFirstName( resultSet.getString( "firstName" ) );
	                student.setLastName( resultSet.getString( "lastName" ) );
	                student.setCourse( resultSet.getString( "course" ) );
	                student.setYear( resultSet.getInt( "year" ) );
	                
	                
	                activityList.add(activity);
	                
	                System.out.println("New Activity Record: " + activity.toString());
	            }
	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return activityList;
	}

	@Override
	public Activity getActivityById(int activityId) {
		Activity activity = new Activity();
	        try {
	        	
	        	StringBuilder queryBuilder = new StringBuilder();
	        	queryBuilder.append("select c.id, c.firstname, c.lastName, c.email, a.idactivity, a.type, ");
	        	queryBuilder.append("a.dateBegin, a.dateClosed, a.durationHours, a.state, a.client_id ");
	        	queryBuilder.append("from activity a ");
	        	queryBuilder.append("inner join client c on a.client_id = c.id ");
	        	queryBuilder.append("where id=?");
	        	
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setInt(1, activityId);
	            
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while(resultSet.next()) {
	            	
	            	activity.setId(resultSet.getInt("idactivity"));
	            	activity.setType(resultSet.getString("type"));
	            	activity.setDateBegin(resultSet.getDate("dateBegin"));
	            	activity.setDateClosed(resultSet.get);
	            	
	            	activity.setDurationHours(durationHours);
	            	activity.setId(id);
	            	activity.setState(state);
	            	activity.setType(type);
	            	
	                student.setStudentId( resultSet.getInt( "studentId" ) );
	                student.setFirstName( resultSet.getString( "firstName" ) );
	                student.setLastName( resultSet.getString( "LastName" ) );
	                student.setCourse( resultSet.getString( "course" ) );
	                student.setYear( resultSet.getInt( "year" ) );
	            }
	            resultSet.close();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return activity;
	}

}
