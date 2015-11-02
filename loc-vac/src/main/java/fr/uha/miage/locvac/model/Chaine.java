package fr.uha.miage.locvac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chaine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idChaine;
	
	private String debut;
	private String fin;
	public int getIdChaine() {
		return idChaine;
	}
	public void setIdChaine(int idChaine) {
		this.idChaine = idChaine;
	}
	public String getDebut() {
		return debut;
	}
	public void setDebut(String debut) {
		this.debut = debut;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	
	
}
