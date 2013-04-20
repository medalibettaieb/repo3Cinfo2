package tn.edu.espritCS.ejb.eRambling.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.espritCS.ejb.eRambling.entities.Group;
import tn.edu.espritCS.ejb.eRambling.services.interfaces.RamblingServicesLocal;
import tn.edu.espritCS.ejb.eRambling.services.interfaces.RamblingServicesRemote;

/**
 * Session Bean implementation class RamblingServices
 */
@Stateless
public class RamblingServices implements RamblingServicesRemote, RamblingServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public RamblingServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void tiSallem() {
		System.out.println("Golna eSallem");
		
	}

	@Override
	public boolean addGroup(Group group) {
		boolean b = false;
		
		try {
			entityManager.persist(group);
			b = true;
		} catch (Exception e) {
			System.out.println("Erreur!!");
		}
		
		return b;
	}
	
	

}
