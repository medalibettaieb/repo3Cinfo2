package tn.edu.espritCS.eRambling.services;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tn.edu.espritCS.eRambling.persistence.Group;
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

			group.setIdGroup(4);
			group.setNameGroup("3Cinfo2");
			group.setDateGroup(new Date());

			String sql = "insert into base.group (idGroup,nameGroup) values(" + group.getIdGroup()
					+ ",'" + group.getNameGroup() + "')";
			statement.executeUpdate(sql);
			System.out.println("Group added ...");
			
//			User user = userDao.findUserByIdUser(2);
//			user.setRefGroup(group.getIdGroup());
//			
//			userDao.updateUser(user);
//			
//			System.out.println("user Modified ...");

			List<User> users = new ArrayList<User>();
			for(User u:users){
				u.setRefGroup(group.getIdGroup());
				userDao.updateUser(u);
			}
			
			b = true;

		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}

		return b;

	}
	
	
	
	
	

}
