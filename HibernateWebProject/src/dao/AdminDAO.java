package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Artikal;
import model.User;

public class AdminDAO {
	
	private SessionFactory sf = new Configuration()
			.configure()
			.buildSessionFactory();
	
	public List<User> vratiSveUsere(){
	
		List<User> listaUsera = new ArrayList<User>();
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			String upit = "FROM User";
			Query query = session.createQuery(upit);
			listaUsera = query.getResultList();
			session.getTransaction().commit();
			System.out.println("Vratio sam listu usera");
			return listaUsera;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("NISAM vratio sam listu usera");
			return listaUsera;
		}finally {
			session.close();
		}
	}
	
	
	
	public void addBalanceToUser(String idUser, String balanceAdded){
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			User user = (User)session.get(User.class, Integer.parseInt(idUser));
			user.setBalance(user.getBalance()+ Double.parseDouble(balanceAdded));
			session.update(user);
			session.getTransaction().commit();
			System.out.println("Dodao sam balance");
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("NISAM dodao balance");
		}finally {
			session.close();
		}
	}



	public void dodajArtikal(Artikal artikal) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			session.save(artikal);
			session.getTransaction().commit();
			System.out.println("Dodao sam artikal");
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("NISAM dodao artikal");
		}finally {
			session.close();
		}
		
	}
	
	

	
	
	
}
