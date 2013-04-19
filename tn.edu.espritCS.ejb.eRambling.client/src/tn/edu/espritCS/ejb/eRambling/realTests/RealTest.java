package tn.edu.espritCS.ejb.eRambling.realTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
		} 
		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
