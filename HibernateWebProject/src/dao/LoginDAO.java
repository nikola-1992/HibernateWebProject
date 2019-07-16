package dao;

import java.util.List;

import model.Admin;
import model.Role;
import model.User;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoginDAO {
	
	private SessionFactory sf = new Configuration()
			.configure()
			.buildSessionFactory();

	public boolean daLiPasswordOdgovaraUseru(String userName, String password) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			String upit = "FROM User WHERE userName = :u";
			Query query = session.createQuery(upit);
			query.setParameter("u", userName);
			List<User> listaUsera = query.getResultList();
			if(!(listaUsera.isEmpty())) {
				User user = listaUsera.get(0);
					if(user.getPassword().equals(password)) {
						session.getTransaction().commit();
						System.out.println("Dobar je pass");
						return true;
					}else {
						session.getTransaction().commit();
						System.out.println("Nije dobar je pass");
						return false;
					}
			}else {
				session.getTransaction().commit();
				return false;
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}

	
	public User vratiUseraPoUserName(String userName) {
		User user = null;
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			String upit = "FROM User WHERE userName = :u";
			Query query = session.createQuery(upit);
			query.setParameter("u", userName);
			List<User> listaUsera = query.getResultList();
				if(!(listaUsera.isEmpty())) {
					user = listaUsera.get(0);
					session.getTransaction().commit();
					System.out.println("Vratio sam usera");
					return user;
				}else {
					session.getTransaction().commit();
					System.out.println("Nema usera");
					return user;
				}
		} catch (Exception e) {
			session.getTransaction().rollback();
			return user;
		}finally {
			session.close();
		}
	}
	

	
	
	
	

}
