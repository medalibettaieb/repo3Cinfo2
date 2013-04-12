package tn.edu.espritCS.hibernate.eRambling.services;

import tn.edu.espritCS.hibernate.eRambling.persistence.Group;
import tn.edu.espritCS.hibernate.eRambling.persistence.User;

// TODO: Auto-generated Javadoc
/**
 * The Class GroupDao.
 */
public class GroupDao extends GeneriqueDao<Group> {

	/**
	 * Instantiates a new group dao.
	 */
	public GroupDao() {
		super(Group.class);
	}

	public boolean initDB() {
		
		boolean b = false;
		
		try {
			

			
			User user = new User();
			
			b=true;
			
		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}
		
		return b;				
	}

}
