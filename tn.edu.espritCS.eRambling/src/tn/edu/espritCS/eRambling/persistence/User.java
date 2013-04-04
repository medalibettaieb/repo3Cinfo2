package tn.edu.espritCS.eRambling.persistence;

public class User {

	private int idUser;
	private String firstNameUser;
	private String lastNameUser;
	private int refGroup;

	public int getIdUser() {
		return idUser;
	}



	public int getRefGroup() {
		return refGroup;
	}



	public void setRefGroup(int refGroup) {
		this.refGroup = refGroup;
	}



	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstNameUser() {
		return firstNameUser;
	}

	public void setFirstNameUser(String firstNameUser) {
		this.firstNameUser = firstNameUser;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}

}
