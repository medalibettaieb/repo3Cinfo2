package tn.edu.espritCS.hibernate.eRambling.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tn.edu.espritCS.hibernate.eRambling.technique.UtileHibernate;

public class TestRealPlatforme {

	@Test
	public void testGetSession() {
		UtileHibernate.getSession();
	}

}
