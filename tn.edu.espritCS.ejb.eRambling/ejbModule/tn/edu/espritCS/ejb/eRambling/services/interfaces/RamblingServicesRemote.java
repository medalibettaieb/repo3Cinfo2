package tn.edu.espritCS.ejb.eRambling.services.interfaces;

import javax.ejb.Remote;

import tn.edu.espritCS.ejb.eRambling.entities.Group;

@Remote
public interface RamblingServicesRemote {
	
	public void tiSallem();
	public boolean addGroup(Group group);
	
}
