package fr.uha.miage.locvac.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DateDispo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDateDispo;
	
	private Date dateDebut;
	private Date dateFin;
	
	
	
	

	public int getIdDateDispo() {
		return idDateDispo;
	}
	public void setIdDateDispo(int idDateDispo) {
		this.idDateDispo = idDateDispo;
	}
	public Date getDateDebut() throws ParseException {
				return dateDebut;
	}
	

	
	
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() throws ParseException {

		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	
	@ManyToOne
	private Location locationDateDispo;

	public Location getLocationDateDispo() {
		return locationDateDispo;
	}
	public void setLocationDateDispo(Location locationDateDispo) {
		this.locationDateDispo = locationDateDispo;
	}
	@Override
	public String toString() {
		return "DateDispo [idDateDispo=" + idDateDispo + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	
	
	
}
