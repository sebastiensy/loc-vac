package fr.uha.miage.locvac.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Equipement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdEquipement;
	
	@Column(length=40)
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
	
	//@ManyToOne
	//private Collection<Location> locations;;
	
	
}
