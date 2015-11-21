package fr.uha.miage.locvac.model;

import fr.uha.miage.locvac.model.TypePropriete;

import java.util.Collection;
import java.util.List;

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
	private String paysLocation;
	
	@Column(length=100)
	private String adresseLocation;
	
	
	private int superficie;
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	private String url;
	
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
	
	// typepropriete
	@ManyToOne
	private TypePropriete typePropriete;
	
	// location dans la classe equipement
	@ManyToMany
	private List<Equipement> equipements;
	
	// location dans la classe typeSdb
	@ManyToMany
	private List<TypeSdb> typeSdbs;
	
	//chambres (mappedBy="locationChambre")
	@OneToMany
	private List<Chambre> chambres;
	
	//date dispo (mappedBy="locationDateDispo")
	@OneToMany
	private List<DateDispo> dateDispo;
	
	
	//reserver
	@OneToMany(mappedBy="locationReserver")
	private List<Reserver> reserver;



	

	@Override
	public String toString() {
		return "Location [idLocation=" + idLocation + ", nomLocation=" + nomLocation + ", capaciteLocation="
				+ capaciteLocation + ", villeLocation=" + villeLocation + ", paysLocation=" + paysLocation
				+ ", adresseLocation=" + adresseLocation + ", superficie=" + superficie + ", url=" + url
				+ ", codePostalLocation=" + codePostalLocation + ", prixLocation=" + prixLocation
				+ ", descriptionLocation=" + descriptionLocation + ", typePropriete=" + typePropriete + ", equipements="
				+ equipements + ", typeSdbs=" + typeSdbs + ", chambres=" + chambres + ", dateDispo=" + dateDispo
				+ ", reserver=" + reserver + "]";
	}
	public TypePropriete getTypePropriete() {
		return typePropriete;
	}
	public void setTypePropriete(TypePropriete typePropriete) {
		this.typePropriete = typePropriete;
	}
	public List<Equipement> getEquipements() {
		return equipements;
	}
	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}
	public List<TypeSdb> getTypeSdbs() {
		return typeSdbs;
	}
	public void setTypeSdbs(List<TypeSdb> typeSdbs) {
		this.typeSdbs = typeSdbs;
	}
	public List<Chambre> getChambres() {
		return chambres;
	}
	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
	public List<DateDispo> getDateDispo() {
		return dateDispo;
	}
	public void setDateDispo(List<DateDispo> dateDispo) {
		this.dateDispo = dateDispo;
	}
	public List<Reserver> getReserver() {
		return reserver;
	}
	public void setReserver(List<Reserver> reserver) {
		this.reserver = reserver;
	}
	
	
	
	
	
	
	
}