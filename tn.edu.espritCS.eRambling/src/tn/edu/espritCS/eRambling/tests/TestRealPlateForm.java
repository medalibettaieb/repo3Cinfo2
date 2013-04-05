package tn.edu.espritCS.eRambling.tests;

import junit.framework.Assert;

import org.junit.Test;

import tn.edu.espritCS.eRambling.services.GroupDao;

public class TestRealPlateForm {
	
	private GroupDao groupDao = new GroupDao();

	@Test
	public void testOrganiseGroup(){
		Assert.assertTrue(groupDao.organiseGroup());
		
		
	}
	
	@Test
	public void testAssignUserToGroup(){
		Assert.assertTrue(groupDao.assignUserToGroup(3,5));
		
	}
	
	@Test
	public void testFindAllGroups(){
		Assert.assertEquals(3, groupDao.findAllGroups().size());
	}
	
	@Test
	public void testLeaveGroup(){
		Assert.assertTrue(groupDao.leaveGroup(3));
		
	}
	
	@Test
	public void testProposeRambling(){
		Assert.assertTrue(groupDao.proposeRambling("Rafraf",4));
	}
	
	
	
	
}
