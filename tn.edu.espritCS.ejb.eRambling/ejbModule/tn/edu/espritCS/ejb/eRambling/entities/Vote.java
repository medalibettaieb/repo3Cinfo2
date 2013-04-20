package tn.edu.espritCS.ejb.eRambling.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_VOTE")
public class Vote implements Serializable {
	
	private int idVote;
	private String state;
	
	private Rambling rambling;
	private User user;

	public Vote(int idVote, String state) {
		
		this.idVote = idVote;
		this.state = state;

	}
	public Vote() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdVote() {
		return idVote;
	}
	public void setIdVote(int idVote) {
		this.idVote = idVote;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@ManyToOne
	public Rambling getRambling() {
		return rambling;
	}
	public void setRambling(Rambling rambling) {
		this.rambling = rambling;
	}
	
	@OneToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
	

}
