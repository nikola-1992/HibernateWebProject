package dao;

import java.util.List;

import model.Admin;
import model.Role;
import model.User;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RegistracijaDAO {
	
	private SessionFactory sf = new Configuration()
			.configure()
			.buildSessionFactory();
	
	public boolean daLiPostojiUserUbazi(String userName) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			String upit = "FROM User WHERE userName = :u";
			Query query = session.createQuery(upit);
			query.setParameter("u", userName);
			List<User> listaUsera = query.getResultList();
				if(!(listaUsera.isEmpty())) {
					session.getTransaction().commit();
					return true;
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
	
	public boolean upisiUseraUbazu(String userName,String password) {
		
		User user =new User();
		user.setUserName(userName);
		user.setPassword(password);
		
		if(userName.equals(Admin.getAdminusername()) 
				&& password.equals(Admin.getAdminpassword())) {
			user.setRole(Role.ADMINISTRATOR);
		}else {
			user.setRole(Role.KORISNIK);
		}
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			session.save(user);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
	
	
	

}
