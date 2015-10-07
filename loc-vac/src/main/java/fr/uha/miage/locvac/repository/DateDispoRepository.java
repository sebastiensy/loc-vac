package fr.uha.miage.locvac.repository;
import fr.uha.miage.locvac.model.DateDispo;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;


public interface DateDispoRepository extends CrudRepository<DateDispo, Integer>{

	
	
	
	
	public DateDispo findByIdDateDispo (int idDateDispo);
	public DateDispo findByDateDebut(Date dateDebut);
	public DateDispo findByDateFin(Date dateFin);
	
	
	// findByStartDateBetween   : where x.startdate between ?? and ??
	public DateDispo findByDateDebutBetween(Date dateDebut, Date dateFin);

}