package tn.edu.espritCS.hibernate.eRambling.services;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.hibernate.Session;

import tn.edu.espritCS.hibernate.eRambling.persistence.User;
import tn.edu.espritCS.hibernate.eRambling.technique.UtileHibernate;

public abstract class GeneriqueDao <T>{
	private Class<T> type;
	private Session session = UtileHibernate.getSession();
	
	public GeneriqueDao() {
		// TODO Auto-generated constructor stub
	}
	
	public GeneriqueDao(Class<T>type){
		this.type = type;
	}
	
	public boolean create(T t){
		
		boolean b = false;
		
		try {
			session.persist(t);
			b=true;
			
		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}
		
		return b;				
		
		
	}
	
	public boolean update(T t){
		
		boolean b = false;
		
		try {
			session.merge(t);
			b=true;
			
		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}
		
		return b;			
		
	}
	
	/**
	 * Delete.
	 *
	 * @param idT the id t
	 * @return true, if successful
	 */
	public boolean delete(int idT){
		boolean b = false;
		
		try { 
			T t = find(idT);
			session.delete(find(idT));
			b=true;
			
		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}
		
		return b;			
	}
	
	public T find(int idT){
		

		T t = null;
		
		try {
			
			t = (T) this.session.get(this.type, idT);
			
		} catch (Exception e) {
			System.err.println("7awel marra thenya");
		}
		
		return t;		
	}
	

}
