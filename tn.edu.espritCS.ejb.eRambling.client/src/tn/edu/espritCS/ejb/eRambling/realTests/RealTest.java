package tn.edu.espritCS.ejb.eRambling.realTests;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.espritCS.ejb.eRambling.entities.Group;
import tn.edu.espritCS.ejb.eRambling.services.interfaces.RamblingServicesRemote;

public class RealTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Context context = new InitialContext();
			RamblingServicesRemote proxy = (RamblingServicesRemote) context
					.lookup("ejb:/tn.edu.espritCS.ejb.eRambling/RamblingServices!tn.edu.espritCS.ejb.eRambling.services.interfaces.RamblingServicesRemote");
		
			proxy.tiSallem();
			Group group = new Group("3Cinfo2", new Date());
		
			proxy.addGroup(group);
		} 
		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
