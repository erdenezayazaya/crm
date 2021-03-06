package edu.mum.mpp.zayagerman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.mum.mpp.zayagerman.entity.ClientOpportunity;
import edu.mum.mpp.zayagerman.entity.DataGraphicOppo;
import edu.mum.mpp.zayagerman.service.ClientOpportunityDAO;
import edu.mum.mpp.zayagerman.settings.DBUtil;
import edu.mum.mpp.zayagerman.settings.Stage;

public class ClientOpportunityDAOImpl implements ClientOpportunityDAO {
	private Connection conn;
	int clientId;

	public ClientOpportunityDAOImpl() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void addClientOpportunity(ClientOpportunity clientOpportunity) {
		try {
			String query = "insert into client(firstname, lastname, email) " + "values (?,?,?)";

			PreparedStatement preparedStatement = conn.prepareStatement(query);

			preparedStatement.setString(1, clientOpportunity.getFirstName());
			preparedStatement.setString(2, clientOpportunity.getLastName());
			preparedStatement.setString(3, clientOpportunity.getEmail());

			preparedStatement.executeUpdate();

			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery("select id from client order by id DESC limit 1");

			while (resultSet.next()) {
				this.clientId = resultSet.getInt("id");
			}
			resultSet.close();
			statement.close();

			query = "insert into client_opportunity (amount, probability, "
					+ "closedDate, description, id_client, stage) values (?,?,?,?,?,?)";

			preparedStatement = conn.prepareStatement(query);

			preparedStatement.setDouble(1, clientOpportunity.getAmount());
			preparedStatement.setInt(2, clientOpportunity.getProbability());
			preparedStatement.setDate(3, clientOpportunity.getCloseDate());
			preparedStatement.setString(4, clientOpportunity.getDescription());
			preparedStatement.setInt(5, this.clientId);
			preparedStatement.setString(6, clientOpportunity.getStage());

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

			PreparedStatement preparedStatement = conn.prepareStatement(query);

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
	public List<DataGraphicOppo> listOpporByStage() {
		List<DataGraphicOppo> list = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select stage, count(*) total from client_opportunity group by stage");

			while (resultSet.next()) {
				list.add(new DataGraphicOppo(Stage.valueOf(resultSet.getString("stage")).getFullName(),
						resultSet.getInt("total")));
			}
			resultSet.close();
			statement.close();
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<ClientOpportunity> getAllClientOpportunitys() {
		List<ClientOpportunity> clientOpportunityList = new ArrayList<ClientOpportunity>();
		try {
			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(
					"select * from client c inner " + "join client_opportunity " + "o on c.id = o.id_client");

			while (resultSet.next()) {
				ClientOpportunity clientOpportunity = new ClientOpportunity();

				clientOpportunity.setId(resultSet.getInt("id"));
				clientOpportunity.setFirstName(resultSet.getString("firstName"));
				clientOpportunity.setLastName(resultSet.getString("lastName"));
				clientOpportunity.setEmail(resultSet.getString("email"));

				clientOpportunity.setId(resultSet.getInt("id"));
				clientOpportunity.setStage(resultSet.getString("stage"));
				clientOpportunity.setAmount(resultSet.getDouble("amount"));
				clientOpportunity.setProbability(resultSet.getInt("probability"));
				clientOpportunity.setCloseDate(resultSet.getDate("closedDate"));
				clientOpportunity.setDescription(resultSet.getString("description"));
				clientOpportunity.setStage(resultSet.getString("stage"));

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
			queryBuilder.append("select * from client c inner ");
			queryBuilder.append("join client_opportunity ");
			queryBuilder.append("o on c.id = o.id_client ");
			queryBuilder.append("where id=? ");

			PreparedStatement preparedStatement = conn.prepareStatement(queryBuilder.toString());
			preparedStatement.setInt(1, clientOpportunityId);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				clientOpportunity.setId(resultSet.getInt("c.id"));
				clientOpportunity.setFirstName("c.firstname");
				clientOpportunity.setLastName("c.lastname");
				clientOpportunity.setEmail("c.email");

				clientOpportunity.setId(resultSet.getInt("o.id"));
				clientOpportunity.setAmount(resultSet.getDouble("o.amount"));
				clientOpportunity.setProbability(resultSet.getInt("o.probability"));
				clientOpportunity.setCloseDate(resultSet.getDate("o.closedDate"));
				clientOpportunity.setDescription(resultSet.getString("o.description"));

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
