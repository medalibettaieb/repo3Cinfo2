package tn.edu.espritCS.hibernate.eRambling.technique;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class UtileHibernate {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public static Session getSession(){
		if(session == null){
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.getCurrentSession();
		}
		
		return session;
	}

}
