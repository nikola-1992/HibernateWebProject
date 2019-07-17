package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Racun {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRacun;
	@OneToOne
	private User user;
	private Date date;
	@OneToMany
	private List<Artikal> listaArtikala = new ArrayList<Artikal>();
	private double total;
	
	public int getIdRacun() {
		return idRacun;
	}
	public void setIdRacun(int idRacun) {
		this.idRacun = idRacun;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Artikal> getListaArtikala() {
		return listaArtikala;
	}
	public void setListaArtikala(List<Artikal> listaArtikala) {
		this.listaArtikala = listaArtikala;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	

}
