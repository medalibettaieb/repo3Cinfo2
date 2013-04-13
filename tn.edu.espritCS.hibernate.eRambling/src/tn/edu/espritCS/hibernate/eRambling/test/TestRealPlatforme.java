package tn.edu.espritCS.hibernate.eRambling.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;


import org.hibernate.Session;
import org.junit.Test;

import tn.edu.espritCS.hibernate.eRambling.persistence.User;
import tn.edu.espritCS.hibernate.eRambling.services.GroupDao;
import tn.edu.espritCS.hibernate.eRambling.services.ManagementServices;
import tn.edu.espritCS.hibernate.eRambling.services.UserDao;
import tn.edu.espritCS.hibernate.eRambling.technique.UtileHibernate;

public class TestRealPlatforme {
	
	private UserDao userDao = new UserDao();

	private Session session =UtileHibernate.getSession();

	private GroupDao groupDao = new GroupDao(); 
	
	private ManagementServices managementServices = new ManagementServices();

	@Test
	public void testGetSession() {
		session =UtileHibernate.getSession(); 
	}
	
	@Test
	public void testAddUser(){
		User user = new User();
		user.setFirstNameUser("Mahdi");
		user.setLastNameUser("Cherif");
		
		session.getTransaction().begin();
		try {
			userDao.create(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		
	}
	
	@Test
	public void testFindUser(){
		User user = null;
		session.getTransaction().begin();
		try {
			user = userDao.find(1);
			session.getTransaction().commit();
			System.out.println(user.getFirstNameUser());
		} catch (Exception e) {
			session.getTransaction().rollback();
		}		
		
	}
	
	@Test
	public void testDeleteUser(){
		
		session.getTransaction().begin();
		try {
			userDao.delete(1);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		}		
	}
	
	@Test
	public void testInitDB(){
		
		session.getTransaction().begin();		
		try {
			Assert.assertTrue(managementServices .initDB());
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}			
		
		
	}
	
	@Test
	public void testOrganiseGroup(){
		
		session.getTransaction().begin();		
		try {
			List<User> femaleUsers = new ArrayList<User>();
			femaleUsers.add(userDao.find(3));
			femaleUsers.add(userDao.find(4));
			
			List<User> maleUsers = new ArrayList<User>();
			maleUsers.add(userDao.find(1));
			maleUsers.add(userDao.find(2));
			maleUsers.add(new User("Khouwadja","Mouhamed"));
			
			
			Assert.assertTrue(managementServices.organiseGroup(maleUsers,1));
			Assert.assertTrue(managementServices.organiseGroup(femaleUsers,2));
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	@Test
	public void testProposeRambling(){
		
		session.getTransaction().begin();		
		try {
			Assert.assertTrue(managementServices.proposeRambling(2,"Ain Draham"));
			Assert.assertTrue(managementServices.proposeRambling(3,"Zaghoun"));
			Assert.assertTrue(managementServices.proposeRambling(4,"Touzeur"));
			Assert.assertTrue(managementServices.proposeRambling(5,"Fa7s"));
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	@Test public void testVoteRambling(){
		session.getTransaction().begin();		
		try {
			
			Assert.assertTrue(managementServices.voteRambling(1,4,"Not OK"));
			Assert.assertTrue(managementServices.voteRambling(2,8,"Not OK"));
			Assert.assertTrue(managementServices.voteRambling(3,8,"OK"));
			Assert.assertTrue(managementServices.voteRambling(4,4,"OK"));
			Assert.assertTrue(managementServices.voteRambling(5,8,"OK"));
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	@Test
	public void testGetGroupByRambling(){
		session.getTransaction().begin();		
		try {
			Assert.assertEquals("bnet", managementServices.getGroupByRambling(4).getNameGroup());
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	@Test
	public void testFindAllVotes(){
		session.getTransaction().begin();		
		try {
			Assert.assertEquals(managementServices.findAllVotes().size(),5);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	@Test
	public void testFinalDestination(){
		session.getTransaction().begin();		
		try {
			Assert.assertEquals(managementServices.finalDestination(),1);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	@Test
	public void testvoteOK(){
		
		session.getTransaction().begin();		
		try {
			Assert.assertEquals(4,managementServices.voteOK(8).size());
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		
	}
	

}
