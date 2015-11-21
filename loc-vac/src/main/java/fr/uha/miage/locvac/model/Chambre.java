package fr.uha.miage.locvac.model;
import fr.uha.miage.locvac.model.TypeLit;


//import org.hibernate.mapping.Collection;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Chambre  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idChambre;

	public int getIdChambre() {
		return idChambre;
	}

	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}
	
	
	@ManyToMany
	private List<TypeLit> typeLits;
	
	@ManyToOne
	private Location locationChambre;

	public List<TypeLit> getTypeLits() {
		return typeLits;
	}

	public void setTypeLits(List<TypeLit> typeLits) {
		this.typeLits = typeLits;
	}

	public Location getLocationChambre() {
		return locationChambre;
	}

	public void setLocationChambre(Location locationChambre) {
		this.locationChambre = locationChambre;
	}

	@Override
	public String toString() {
		return "Chambre [idChambre=" + idChambre + ", typeLits=" + typeLits + "]";
	}
	
	
	
	

}
