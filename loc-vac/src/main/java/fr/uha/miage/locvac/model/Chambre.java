package fr.uha.miage.locvac.model;

import javax.persistence.Entity;

@Entity
public class Chambre {
	
	private int idChambre;

	public int getIdChambre() {
		return idChambre;
	}

	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}
	
	

}
