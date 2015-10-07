package fr.uha.miage.locvac.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reserver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReserver;
	
	private Date dateDebutReserver;
	private Date dateFinReserver;
	private double prixReserver;
	
	
	
	// getter & setter
	
	public int getIdReserver() {
		return idReserver;
	}
	public void setIdReserver(int idReserver) {
		this.idReserver = idReserver;
	}
	public Date getDateDebutReserver() {
		return dateDebutReserver;
	}
	public void setDateDebutReserver(Date dateDebutReserver) {
		this.dateDebutReserver = dateDebutReserver;
	}
	public Date getDateFinReserver() {
		return dateFinReserver;
	}
	public void setDateFinReserver(Date dateFinReserver) {
		this.dateFinReserver = dateFinReserver;
	}
	public double getPrixReserver() {
		return prixReserver;
	}
	public void setPrixReserver(double prixReserver) {
		this.prixReserver = prixReserver;
	}
	
	
	@ManyToOne
	private Location locationReserver;

	@ManyToOne
	private User userReserver;
	
	
}
