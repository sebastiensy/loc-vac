package fr.uha.miage.locvac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypePropriete {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTypeProp;
	
	private String nomTypePropriete;

	public int getIdTypeProp() {
		return idTypeProp;
	}

	public void setIdTypeProp(int idTypeProp) {
		this.idTypeProp = idTypeProp;
	}

	public String getNomTypePropriete() {
		return nomTypePropriete;
	}

	public void setNomTypePropriete(String nomTypePropriete) {
		this.nomTypePropriete = nomTypePropriete;
	}
	
	
	
	
}
