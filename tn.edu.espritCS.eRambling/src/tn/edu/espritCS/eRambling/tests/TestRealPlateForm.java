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
	
	
	
	
}
