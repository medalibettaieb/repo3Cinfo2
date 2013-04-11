package tn.edu.espritCS.hibernate.eRambling.test;

import static org.junit.Assert.*;
import junit.framework.Assert;


import org.hibernate.Session;
import org.junit.Test;

import tn.edu.espritCS.hibernate.eRambling.persistence.User;
import tn.edu.espritCS.hibernate.eRambling.services.UserDao;
import tn.edu.espritCS.hibernate.eRambling.technique.UtileHibernate;

public class TestRealPlatforme {
	
	private UserDao userDao = new UserDao();
	private Session session =UtileHibernate.getSession(); 

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
	
	

}
