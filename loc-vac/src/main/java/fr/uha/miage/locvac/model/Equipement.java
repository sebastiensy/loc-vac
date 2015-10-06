package fr.uha.miage.locvac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Equipement {

	@Id
	@GeneratedValue
	private int IdEquipement;
	
	
	private String nomEquipement;


	public int getIdEquipement() {
		return IdEquipement;
	}


	public void setIdEquipement(int idEquipement) {
		IdEquipement = idEquipement;
	}


	public String getNomEquipement() {
		return nomEquipement;
	}


	public void setNomEquipement(String nomEquipement) {
		this.nomEquipement = nomEquipement;
	}
	
}
