package tn.edu.espritCS.eRambling.tests;

import junit.framework.Assert;

import org.junit.Test;

import tn.edu.espritCS.eRambling.persistence.User;
import tn.edu.espritCS.eRambling.services.GroupDao;
import tn.edu.espritCS.eRambling.services.UserDao;
import tn.edu.espritCS.eRambling.technique.JdbcUtilities;

public class TestManageUser {

	private JdbcUtilities jdbcUtilities = new JdbcUtilities();
	private UserDao userDao = new UserDao();

	@Test
	public void testAddUser() {
		// creation of the entity
		User user = new User();
		user.setFirstNameUser("foulen");
		user.setLastNameUser("ben foulen");

		// creation of the dao Class

		Assert.assertEquals(true, userDao.addUser(user));
	}

	@Test
	public void testHatliConnection() {
		JdbcUtilities jdbcUtilities = new JdbcUtilities();
		Assert.assertEquals("", jdbcUtilities.hatliConnectionMrigla());
	}

	@Test
	public void testFindUserByIdUser() {

		Assert.assertEquals("ff", userDao.findUserByIdUser(1)
				.getFirstNameUser());
	}

	@Test
	public void testUpdateUser() {
		User userModel = userDao.findUserByIdUser(1);
		userModel.setFirstNameUser("new ");
		userModel.setLastNameUser("new ");

		Assert.assertTrue(userDao.updateUser(userModel));
	}


	@Test
	public void testDeleteUserByIdUser() {
		Assert.assertTrue(userDao.deleteUserByIdUser(1));
	}
	
	@Test
	public void testFindAllUsers(){
		Assert.assertEquals(1, userDao.findAllUsers().size());
	}
	

}
