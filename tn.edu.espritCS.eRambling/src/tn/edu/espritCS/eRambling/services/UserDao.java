package tn.edu.espritCS.eRambling.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.espritCS.eRambling.persistence.User;
import tn.edu.espritCS.eRambling.technique.JdbcUtilities;

public class UserDao {

	private JdbcUtilities jdbcUtilities = new JdbcUtilities();
	private Connection connection = jdbcUtilities.hatliConnectionMrigla();

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

}
