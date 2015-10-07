package fr.uha.miage.locvac.model;

import fr.uha.miage.locvac.model.TypePropriete;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLocation;
	
	@Column(length=100)
	private String nomLocation;
	
	
	private int capaciteLocation;
	
	@Column(length=40)
	private String villeLocation;
	
	@Column(length=40)
	private String typeProprieteLocation;
	
	@Column(length=40)
	private String paysLocation;
	
	@Column(length=100)
	private String adresseLocation;
	
	
	private int codePostalLocation;
	
	
	private double prixLocation;
	
	
	@Column(length=1000)
	private String descriptionLocation;
	
	
	
	public int getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}
	public String getNomLocation() {
		return nomLocation;
	}
	public void setNomLocation(String nomLocation) {
		this.nomLocation = nomLocation;
	}
	public int getCapaciteLocation() {
		return capaciteLocation;
	}
	public void setCapaciteLocation(int capaciteLocation) {
		this.capaciteLocation = capaciteLocation;
	}
	public String getVilleLocation() {
		return villeLocation;
	}
	public void setVilleLocation(String villeLocation) {
		this.villeLocation = villeLocation;
	}
	public String getTypeProprieteLocation() {
		return typeProprieteLocation;
	}
	public void setTypeProprieteLocation(String typeProprieteLocation) {
		this.typeProprieteLocation = typeProprieteLocation;
	}
	public String getPaysLocation() {
		return paysLocation;
	}
	public void setPaysLocation(String paysLocation) {
		this.paysLocation = paysLocation;
	}
	public String getAdresseLocation() {
		return adresseLocation;
	}
	public void setAdresseLocation(String adresseLocation) {
		this.adresseLocation = adresseLocation;
	}
	public int getCodePostalLocation() {
		return codePostalLocation;
	}
	public void setCodePostalLocation(int codePostalLocation) {
		this.codePostalLocation = codePostalLocation;
	}
	public double getPrixLocation() {
		return prixLocation;
	}
	public void setPrixLocation(double prixLocation) {
		this.prixLocation = prixLocation;
	}
	public String getDescriptionLocation() {
		return descriptionLocation;
	}
	public void setDescriptionLocation(String descriptionLocation) {
		this.descriptionLocation = descriptionLocation;
	}
	
	
	// location dans la classe equipement
	@ManyToMany(mappedBy="locations")
	private Collection<Equipement> equipements;
	
	// location dans la classe typeSdb
	@ManyToMany(mappedBy="locations")
	private Collection<TypeSdb> typeSdbs;
	
	
	// typepropriete
	@ManyToOne
	private TypePropriete typePropriete;
	
	
	//chambres
	@OneToMany(mappedBy="locationChambre")
	private Collection<Chambre> chambres;
	
	
	//date dispo
	@OneToMany(mappedBy="locationDateDispo")
	private Collection<DateDispo> dateDispo;
	
	
	//reserver
	@OneToMany(mappedBy="locationReserver")
	private Collection<Reserver> reserver;
	
	
	
}