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
public class TypeSdb {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTsdb;
	
	
	@Column(length=40)
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
	
	
	
	@Override
	public String toString() {
		return "TypeSdb [idTsdb=" + idTsdb + ", nomTsdb=" + nomTsdb + "]";
	}



	@ManyToMany(mappedBy="typeSdbs")
	private List<Location> locations;

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	
	
}
