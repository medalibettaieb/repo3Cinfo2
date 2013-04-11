package tn.edu.espritCS.hibernate.eRambling.services;

import tn.edu.espritCS.hibernate.eRambling.persistence.User;

public class UserDao extends GeneriqueDao<User>{
	

	/**
	 * Instantiates a new user dao.
	 */
	public UserDao() {
		super(User.class);
	}
	
	

}
