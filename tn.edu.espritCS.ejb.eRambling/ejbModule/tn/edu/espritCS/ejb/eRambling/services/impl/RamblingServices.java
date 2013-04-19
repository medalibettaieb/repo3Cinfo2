package tn.edu.espritCS.ejb.eRambling.services.impl;

import javax.ejb.Stateless;
import tn.edu.espritCS.ejb.eRambling.services.interfaces.RamblingServicesLocal;
import tn.edu.espritCS.ejb.eRambling.services.interfaces.RamblingServicesRemote;

/**
 * Session Bean implementation class RamblingServices
 */
@Stateless
public class RamblingServices implements RamblingServicesRemote, RamblingServicesLocal {

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

}
