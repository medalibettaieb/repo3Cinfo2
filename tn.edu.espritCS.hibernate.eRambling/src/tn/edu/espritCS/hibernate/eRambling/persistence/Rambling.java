package tn.edu.espritCS.hibernate.eRambling.persistence;

public class Rambling {
	
	private int idRambling;
	private String destianation;
	
	public Rambling() {
		
	}
	public Rambling(int idRambling, String destianation) {
		
		this.idRambling = idRambling;
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
	
	
	

}
