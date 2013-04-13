package tn.edu.espritCS.hibernate.eRambling.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tn.edu.espritCS.hibernate.eRambling.persistence.Group;
import tn.edu.espritCS.hibernate.eRambling.persistence.Rambling;
import tn.edu.espritCS.hibernate.eRambling.persistence.User;
import tn.edu.espritCS.hibernate.eRambling.persistence.Vote;
import tn.edu.espritCS.hibernate.eRambling.technique.UtileHibernate;

public class ManagementServices {

	private Session session = UtileHibernate.getSession();
	private GroupDao groupDao = new GroupDao();
	private UserDao userDao = new UserDao();
	private RamblingDao ramblingDao = new RamblingDao();
	private VoteDao voteDao = new VoteDao();

	public boolean initDB() {

		boolean b = false;

		try {

			Group group = new Group("Awled", new Date());
			Group group2 = new Group("Bnet", new Date());

			User user = new User("Cherif", "Mahdi");
			User user2 = new User("hedhili", "Marwen");
			User user3 = new User("Laoyouni", "Roukaya");
			User user4 = new User("Moulehi", "Meriem");

			Rambling rambling = new Rambling("Ain Draham");
			Rambling rambling2 = new Rambling("Korbous");
			Rambling rambling3 = new Rambling("Wed Zitoun");

			session.persist(group);
			session.persist(group2);

			session.persist(user);
			session.persist(user2);
			session.persist(user3);
			session.persist(user4);

			session.persist(rambling);
			session.persist(rambling2);
			session.persist(rambling3);

			b = true;

		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}

		return b;
	}

	public boolean organiseGroup(List<User> users, int idGroup) {
		boolean b = false;

		try {

			Group groupFounded = groupDao.find(idGroup);
			groupFounded.setUsers(users);
			groupDao.update(groupFounded);
			b = true;

		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}

		return b;
	}

	public boolean proposeRambling(int idUser, String destianation) {
		boolean b = false;
		try {

			User userFounded = userDao.find(idUser);
			Rambling rambling = new Rambling(destianation);
			rambling.setUser(userFounded);

			ramblingDao.update(rambling);

			b = true;

		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}

		return b;
	}

	public boolean voteRambling(int idUser, int idRambling, String state) {
		boolean b = false;

		try {

			User userFounded = userDao.find(idUser);
			Rambling ramblingFounded = ramblingDao.find(idRambling);

			List<Vote> votes = findAllVotes();
			boolean test = true;
			for (Vote vote : votes) {
				if (vote.getUser().equals(userFounded))
					test = false;
			}

			if (test) {
				if (userFounded.getGroup().equals(
						getGroupByRambling(idRambling))) {

					Vote vote = new Vote();
					vote.setRambling(ramblingFounded);
					vote.setUser(userFounded);
					vote.setState(state);

					voteDao.create(vote);
				} else
					System.out.println("Yézzi w Telhé fi Rou7ek :D");

			}else System.out.println("Barra Al3ab B3id chl9na Bik");

			b = true;

		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}

		return b;
	}

	public Group getGroupByRambling(int idRambling) {

		Rambling rambling = ramblingDao.find(idRambling);
		User user = rambling.getUser();
		return user.getGroup();

	}

	public List<Vote> findAllVotes() {

		List<Vote> votes = null;
		try {

			String hql = "from Vote";
			Query query = session.createQuery(hql);

			votes = new ArrayList<Vote>();
			votes = query.list();

		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}

		return votes;
	}

	
	public List<Vote> voteOK(int idRambling )
	{
		Rambling rambling = ramblingDao.find(idRambling);
		List<Vote> VoteOK = new ArrayList<Vote>();
		
		String hql = "from Vote as v where v.state = 'OK' and v.rambling = " + rambling ;
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	
	public Rambling finalDestination() {

		Rambling ramblingFinalDestination = new Rambling();
		List<Rambling> ramblings = null;
		
		try {
			
			
			String hql = "from Rambling";
			Query query = session.createQuery(hql);
			ramblings = new ArrayList<Rambling>();
			ramblings = query.list();
			List<Vote> votes = null;
			int maxVote = 0;
			
			for (Rambling rambling : ramblings) {
				
				if(rambling.getVotes().size()>maxVote){ 
					ramblingFinalDestination = rambling ;
					maxVote = rambling.getVotes().size();
							} 
			}
			
		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}
		
		return 	ramblingFinalDestination;			
	}

}
