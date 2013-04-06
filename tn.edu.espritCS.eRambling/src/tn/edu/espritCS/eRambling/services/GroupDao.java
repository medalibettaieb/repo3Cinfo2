package tn.edu.espritCS.eRambling.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import tn.edu.espritCS.eRambling.persistence.Group;
import tn.edu.espritCS.eRambling.persistence.Rambling;
import tn.edu.espritCS.eRambling.persistence.User;
import tn.edu.espritCS.eRambling.technique.JdbcUtilities;

public class GroupDao {

	private JdbcUtilities jdbcUtilities = new JdbcUtilities();
	private Connection connection = jdbcUtilities.hatliConnectionMrigla();
	private Statement statement;
	private UserDao userDao = new UserDao();

	public boolean organiseGroup() {

		boolean b = false;

		try {

			statement = connection.createStatement();

			Group group = new Group();

			group.setIdGroup(5);
			group.setNameGroup("3Cinfo2");
			group.setDateGroup(new Date(113, 03, 05));

			String sql = "insert into base.group values(" + group.getIdGroup()
					+ ",'" + group.getNameGroup() + "','"
					+ group.getDateGroup() + "')";
			statement.executeUpdate(sql);
			System.out.println("Group added ...");

			// User user = userDao.findUserByIdUser(2);
			// user.setRefGroup(group.getIdGroup());
			//
			// userDao.updateUser(user);
			//
			// System.out.println("user Modified ...");

			List<User> users = new ArrayList<User>();
			for (User u : users) {
				u.setRefGroup(group.getIdGroup());
				userDao.updateUser(u);
			}

			b = true;

		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}

		return b;

	}

	/**
	 * Assign user to group.
	 * 
	 * @param idUser
	 *            the id user
	 * @param idGroup
	 *            the id group
	 * @return true, if successful
	 */
	public boolean assignUserToGroup(int idUser, int idGroup) {
		boolean b = false;

		try {

			User userFounded = userDao.findUserByIdUser(idUser);
			userFounded.setRefGroup(idGroup);

			userDao.updateUser(userFounded);

			b = true;

		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}

		return b;

	}

	public List<Group> findAllGroups() {
		List<Group> groups = new ArrayList<Group>();

		String sql = "select * from base.group";

		ResultSet resultSet;
		int i;
		Group group = new Group();
		try {

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				group.setNameGroup(resultSet.getString("nameGroup"));
				group.setIdGroup(resultSet.getInt("idGroup"));
				group.setDateGroup(resultSet.getDate("dateGroup"));
				groups.add(group);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return groups;

	}

	public boolean leaveGroup(int idUser) {
		boolean b = false;

		try {

			String sql = "update base.user set fkGroup = null where idUser="
					+ idUser;
			statement.executeUpdate(sql);

			b = true;

		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}

		return b;

	}

	public boolean proposeRambling(String destination, int idUser) {
		boolean b = false;

		try {

			String sql = "insert into base.rambling (destination,fkUser) values (?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, destination);
			preparedStatement.setInt(2, idUser);
			preparedStatement.executeUpdate();
			b = true;

		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}

		return b;
	}

	public List<Rambling> displayRamblingByGroup(int idGroup) {
		List<Rambling> ramblings = new ArrayList<Rambling>();

		String sql = "select r.* from base.rambling as r,"
				+ "base.user as u where r.fkUser=u.idUser and fkGroup="
				+ idGroup;

		ResultSet resultSet;
		int i;
		Rambling rambling = new Rambling();
		try {

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				rambling.setIdRambling(resultSet.getInt("idRambling"));
				rambling.setDestianation(resultSet.getString("destination"));
				rambling.setIdUser(resultSet.getInt("fkUser"));
				ramblings.add(rambling);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ramblings;
	}

	public boolean vote(int idUser, String state, int idRambling)
			throws SQLException {
		boolean b = false;

		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			String sql = "select * from base.vote where idUser=" + idUser;
			resultSet = statement.executeQuery(sql);
			System.err.println("Already Voted");
		} catch (Exception e) {

			try {

				String sql2 = "insert into base.vote (state,idUser,idRambling) values (?,?,?)";
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql2);
				preparedStatement.setString(1, state);
				preparedStatement.setInt(2, idUser);
				preparedStatement.setInt(3, idRambling);
				preparedStatement.executeUpdate();
				b = true;

			} catch (Exception e1) {
				System.err.println("7awel marra thenya");
			}
		}

		return b;

	}

	public int displayFinalDestination(int idGroup) {

		List<Rambling> ramblings = displayRamblingByGroup(idGroup);
		int finalDestination = 0;
		try {
			statement = connection.createStatement();
			
			String sql = "select count(idVote) as total,idRambling from base.vote where state like 'ok' group by idRambling";
			ResultSet resultSet = statement.executeQuery(sql);
			int maxVote = 0;
			
			while (resultSet.next()) {
				
				for (Rambling r : ramblings) {
					
					if(r.getIdRambling() == resultSet.getInt("idRambling")){
						if(resultSet.getInt("total")>maxVote){
							finalDestination = r.getIdRambling();
							maxVote = resultSet.getInt("total");
						}
					}
	
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}


		return finalDestination;
	}

}
