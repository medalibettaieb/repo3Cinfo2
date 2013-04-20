package tn.edu.espritCS.ejb.eRambling.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_GROUP")
public class Group implements Serializable {
	
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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@OneToMany(mappedBy="group")
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
	

}
