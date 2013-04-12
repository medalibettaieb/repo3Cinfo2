package tn.edu.espritCS.hibernate.eRambling.persistence;

import java.util.Date;
import java.util.List;

public class Group {
	
	private int idGroup;
	private String nameGroup;
	private Date dateGroup;
	
	private List<User> users;
	
	public Group( String nameGroup, Date dateGroup) {

	
		this.nameGroup = nameGroup;
		this.dateGroup = dateGroup;
	}
	
	public Group() {
		
	}

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public String getNameGroup() {
		return nameGroup;
	}

	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}

	public Date getDateGroup() {
		return dateGroup;
	}

	public void setDateGroup(Date dateGroup) {
		this.dateGroup = dateGroup;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
	

}
