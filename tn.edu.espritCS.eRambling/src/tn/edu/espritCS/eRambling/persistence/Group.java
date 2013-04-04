package tn.edu.espritCS.eRambling.persistence;

import java.util.Date;

public class Group {
	
	private int idGroup;
	private String nameGroup;
	private Date dateGroup;
	
	public Group(int idGroup, String nameGroup, Date dateGroup) {

		this.idGroup = idGroup;
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
	
	
	
	
	

}
