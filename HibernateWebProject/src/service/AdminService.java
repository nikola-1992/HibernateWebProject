package service;

import java.util.List;

import dao.AdminDAO;
import model.Artikal;
import model.User;

public class AdminService {
	
	AdminDAO dao = new AdminDAO();
	
	public List<User> vratiSveUsere(){
		return dao.vratiSveUsere();
	}

	public void dodajArtikal(Artikal artikal) {
		dao.dodajArtikal(artikal);	
	}
}
