package fr.uha.miage.locvac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeSdb {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTsdb;
	
	private	String nomTsdb;

	public int getIdTsdb() {
		return idTsdb;
	}

	public void setIdTsdb(int idTsdb) {
		this.idTsdb = idTsdb;
	}

	public String getNomTsdb() {
		return nomTsdb;
	}

	public void setNomTsdb(String nomTsdb) {
		this.nomTsdb = nomTsdb;
	}
	
	
	
}
