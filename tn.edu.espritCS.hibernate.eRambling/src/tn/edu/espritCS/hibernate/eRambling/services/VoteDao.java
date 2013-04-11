package tn.edu.espritCS.hibernate.eRambling.services;

import tn.edu.espritCS.hibernate.eRambling.persistence.Vote;

public class VoteDao extends GeneriqueDao<Vote> {
	
	/**
	 * Instantiates a new vote dao.
	 */
	public VoteDao() {
		super(Vote.class);
	}

}
