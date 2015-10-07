package fr.uha.miage.locvac.model;
//import fr.uha.miage.locvac.model.Location;
//import java.util.Collection;
//import org.hibernate.mapping.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;

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
	
	
//	@ManyToOne
//	private Collection<Location> locations;
	
	
	
}
