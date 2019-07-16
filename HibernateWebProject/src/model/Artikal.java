package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Artikal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idArtikal;
	private String imeArtikla;
	private double cena;
	private int stanje;
	@Transient
	private int kolicina;
	public int getIdArtikal() {
		return idArtikal;
	}
	public void setIdArtikal(int idArtikal) {
		this.idArtikal = idArtikal;
	}
	public String getImeArtikla() {
		return imeArtikla;
	}
	public void setImeArtikla(String imeArtikla) {
		this.imeArtikla = imeArtikla;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public int getStanje() {
		return stanje;
	}
	public void setStanje(int stanje) {
		this.stanje = stanje;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	
	
	
	
	
	
}
