package fr.uha.miage.locvac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeLit {

	@Id
	@GeneratedValue
	private int idTypeLit;
	
	private String nomLit;

	public int getIdTypeLit() {
		return idTypeLit;
	}

	public void setIdTypeLit(int idTypeLit) {
		this.idTypeLit = idTypeLit;
	}

	public String getNomLit() {
		return nomLit;
	}

	public void setNomLit(String nomLit) {
		this.nomLit = nomLit;
	}
	

}
