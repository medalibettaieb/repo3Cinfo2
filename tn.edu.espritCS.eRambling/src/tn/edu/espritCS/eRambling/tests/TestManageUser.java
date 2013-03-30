package tn.edu.espritCS.eRambling.tests;

import junit.framework.Assert;

import org.junit.Test;

import tn.edu.espritCS.eRambling.persistence.User;
import tn.edu.espritCS.eRambling.services.UserDao;
import tn.edu.espritCS.eRambling.technique.JdbcUtilities;

public class TestManageUser {

	@Test
	public void testAddUser() {
		// creation of the entity
		User user = new User();
	
		user.setFirstNameUser("foulen");
		user.setLastNameUser("ben foulen");

		// creation of the dao Class
		UserDao userDao = new UserDao();

		Assert.assertEquals(true, userDao.addUser(user));
	}

	@Test
	public void testHatliConnection() {
		JdbcUtilities jdbcUtilities = new JdbcUtilities();
		Assert.assertEquals("", jdbcUtilities.hatliConnectionMrigla());
	}
}
