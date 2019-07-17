package service;

import java.util.List;

import dao.KorisnikDAO;
import model.Artikal;

public class KorisnikService {
	
	KorisnikDAO dao = new KorisnikDAO();
	
	public List<Artikal> vratiSveArtikle(){
		return dao.vratiSveArtikle();
	}

}
