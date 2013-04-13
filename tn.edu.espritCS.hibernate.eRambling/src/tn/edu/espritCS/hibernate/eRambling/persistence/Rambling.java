package tn.edu.espritCS.hibernate.eRambling.persistence;

import java.util.List;

public class Rambling {
	
	private int idRambling;
	private String destianation;
	
	private User user;
	private List<Vote>votes;
	
	public Rambling() {
		
	}
	
	public Rambling(String destianation) {
		
		this.destianation = destianation;
	}
	

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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Vote> getVotes() {
		return votes;
	}
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
	
	
	

}
