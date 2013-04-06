package tn.edu.espritCS.eRambling.technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import tn.edu.espritCS.eRambling.persistence.User;

public class JdbcUtilities {
	private Connection connection;

	public Connection hatliConnectionMrigla() {
		String url = "jdbc:mysql://localhost:3306/base";
		String user = "root";
		String password = "";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded ...");
			} catch (ClassNotFoundException e) {
				System.err.println("still loading ...");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("connection sibon ...");
		} catch (SQLException e) {
			System.err.println("7awel marra o5ra ...");
			e.printStackTrace();
		}

		return connection;
	}

	
}
