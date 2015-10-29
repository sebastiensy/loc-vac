package fr.uha.miage.locvac.model;


import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Equipement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEquipement;
	
	@Column(length=40)
	private String nomEquipement;


	public int getIdEquipement() {
		return idEquipement;
	}


	public void setIdEquipement(int idEquipement) {
		this.idEquipement = idEquipement;
	}


	public String getNomEquipement() {
		return nomEquipement;
	}


	public void setNomEquipement(String nomEquipement) {
		this.nomEquipement = nomEquipement;
	}
	
	@ManyToMany
	private List<Location> locations;


	@Override
	public String toString() {
		return "Equipement [idEquipement=" + idEquipement + ", nomEquipement=" + nomEquipement + "]";
	}


	public List<Location> getLocations() {
		return locations;
	}


	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	
	
}
