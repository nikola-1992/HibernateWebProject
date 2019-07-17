package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Artikal;

public class KorisnikDAO {
	
	private SessionFactory sf = new Configuration()
			.configure()
			.buildSessionFactory();

	public List<Artikal> vratiSveArtikle() {
		
		List<Artikal> listaArtikala = new ArrayList<Artikal>();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			String upit = "FROM Artikal";
			Query query = session.createQuery(upit);
			listaArtikala = query.getResultList();
			session.getTransaction().commit();
			System.out.println("Vratio sam listu artikala");
			return listaArtikala;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("NISAM vratio sam listu artikala");
			return listaArtikala;
		}finally {
			session.close();
		}
	}


}
