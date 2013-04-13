package tn.edu.espritCS.hibernate.eRambling.persistence;

import java.util.List;

public class User {

	private int idUser;
	private String firstNameUser;
	private String lastNameUser;

	private Group group;
	private List<Rambling> ramblings;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String firstNameUser, String lastNameUser) {

		this.firstNameUser = firstNameUser;
		this.lastNameUser = lastNameUser;
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Rambling> getRamblings() {
		return ramblings;
	}

	public void setRamblings(List<Rambling> ramblings) {
		this.ramblings = ramblings;
	}

}
