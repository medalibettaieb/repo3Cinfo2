package tn.edu.espritCS.ejb.eRambling.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_USER")
public class User implements Serializable {

	private int idUser;
	private String firstNameUser;
	private String lastNameUser;

	private Group group;
	private List<Rambling> ramblings;
	private Vote vote;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@ManyToOne
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@OneToMany(mappedBy="user")
	public List<Rambling> getRamblings() {
		return ramblings;
	}

	public void setRamblings(List<Rambling> ramblings) {
		this.ramblings = ramblings;
	}

	@OneToOne(mappedBy="user")
	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

}
