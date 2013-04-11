package tn.edu.espritCS.hibernate.eRambling.services;

import tn.edu.espritCS.hibernate.eRambling.persistence.Rambling;

public class RamblingDao extends GeneriqueDao<Rambling> {

	/**
	 * Instantiates a new rambling dao.
	 */
	public RamblingDao() {
		super(Rambling.class);
	}

}
