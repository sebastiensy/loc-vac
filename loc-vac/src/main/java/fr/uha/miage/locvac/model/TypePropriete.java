package fr.uha.miage.locvac.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypePropriete {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTypeProp;
	
	
	@Column(length=40)
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
	
	
	@OneToMany(mappedBy="typePropriete")
	private Collection<Location> locations;

	@Override
	public String toString() {
		return "TypePropriete [idTypeProp=" + idTypeProp + ", nomTypePropriete=" + nomTypePropriete + "]";
	}
	
	
	
}
