package tn.edu.espritCS.eRambling.persistence;

public class Vote {
	
	private int idVote;
	private String state;
	private int refUser;
	private int refRambling;
	public Vote(int idVote, String state, int refUser, int refRambling) {
		
		this.idVote = idVote;
		this.state = state;
		this.refUser = refUser;
		this.refRambling = refRambling;
	}
	public Vote() {
		
	}
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
	public int getRefUser() {
		return refUser;
	}
	public void setRefUser(int refUser) {
		this.refUser = refUser;
	}
	public int getRefRambling() {
		return refRambling;
	}
	public void setRefRambling(int refRambling) {
		this.refRambling = refRambling;
	}
	
	
	

}
