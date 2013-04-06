package tn.edu.espritCS.hibernate.eRambling.persistence;

public class Vote {
	
	private int idVote;
	private String state;

	public Vote(int idVote, String state) {
		
		this.idVote = idVote;
		this.state = state;

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

	
	
	

}
