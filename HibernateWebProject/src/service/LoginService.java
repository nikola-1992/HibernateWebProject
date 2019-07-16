package service;

import dao.LoginDAO;
import dao.RegistracijaDAO;
import model.User;

public class LoginService {
	
	LoginDAO logindao = new LoginDAO();
	RegistracijaDAO registracijadao = new RegistracijaDAO();
	
	public boolean daLiPostojiUserUbazi(String userName) {
		return registracijadao.daLiPostojiUserUbazi(userName);
	}

	public boolean daLiPasswordOdgovaraUseru(String userName, String password) {
		return logindao.daLiPasswordOdgovaraUseru(userName,password);
	}

	public User vratiUseraPoUserName(String userName) {
		return logindao.vratiUseraPoUserName(userName);
	}
	
	
	
}
