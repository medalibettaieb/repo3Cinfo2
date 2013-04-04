package tn.edu.espritCS.eRambling.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.espritCS.eRambling.persistence.User;
import tn.edu.espritCS.eRambling.technique.JdbcUtilities;

public class UserDao {

	private JdbcUtilities jdbcUtilities = new JdbcUtilities();
	private Connection connection = jdbcUtilities.hatliConnectionMrigla();
	private Statement statement;

	public boolean addUser(User user) {
		boolean b = false;
		Statement statement = null;
		// operations
		try {
			statement = connection.createStatement();
			String sql = "insert into user (firstNameUser,lastNameUser) values ('"
					+ user.getFirstNameUser()
					+ "','"
					+ user.getLastNameUser()
					+ "')";
			statement.executeUpdate(sql);
			System.out.println("user added ...");
			b = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.err.println("ooops ....");
		}

		return b;
	}

	public User findUserByIdUser(int idUser) {
		User user = new User();
		String sql = "select * from user where idUser = " + idUser;

		ResultSet resultSet;
		try {

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.first()) {
				user.setIdUser(resultSet.getInt("idUser"));
				user.setFirstNameUser(resultSet.getString("firstNameUser"));
				user.setLastNameUser(resultSet.getString("lastNameUser"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public Statement getStatement() throws SQLException {
		statement = connection.createStatement();
		return statement;
	}

	public boolean updateUser(User userModel) {
		boolean b = false;
		String sql = "update user set firstNameUser= '"
				+ userModel.getFirstNameUser() + "' , lastNameUser='"
				+ userModel.getLastNameUser() + "', fkGroup="
				+ userModel.getRefGroup() + " where idUser = "
				+ userModel.getIdUser();

		try {
			getStatement().executeUpdate(sql);
			b = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean deleteUserByIdUser(int idUser) {
		boolean b = false;
		String sql = "delete from user where idUser = " + idUser;

		try {
			getStatement().executeUpdate(sql);
			b = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public List<User> findAllUsers() {
		
		List<User> users = new ArrayList<User>();
		
		String sql = "select * from user";

		ResultSet resultSet;
		int i;
		User user = new User();
		try {

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while(resultSet.next()){
				 i = resultSet.getInt("idUser");
				 user = findUserByIdUser(i);
				 users.add(user);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
		
	}

}
