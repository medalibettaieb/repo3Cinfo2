package tn.edu.espritCS.ejb.eRambling.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_RAMBLING")
public class Rambling implements Serializable {
	
	private int idRambling;
	private String destianation;
	
	private User user;
	private List<Vote>votes;
	
	public Rambling() {
		
	}
	
	public Rambling(String destianation) {
		
		this.destianation = destianation;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdRambling() {
		return idRambling;
	}
	public void setIdRambling(int idRambling) {
		this.idRambling = idRambling;
	}
	public String getDestianation() {
		return destianation;
	}
	public void setDestianation(String destianation) {
		this.destianation = destianation;
	}
	
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy="rambling")
	public List<Vote> getVotes() {
		return votes;
	}
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
	
	
	

}
