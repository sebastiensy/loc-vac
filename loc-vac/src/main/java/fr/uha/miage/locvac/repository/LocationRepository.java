package fr.uha.miage.locvac.repository;
import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.locvac.model.Location;

public interface LocationRepository extends CrudRepository<Location, Integer>{
	
	public Location findByIdLocation(int idLocation);
	public Location findByNomLocation(String nomLocation);
	public Location findByCapaciteLocation(int capaciteLocation);
	public Location findByVilleLocation(String villeLocation);
	public Location findByPaysLocation(String paysLocation);
	public Location findByCodePostalLocation(int codePostalLocation);
	public Location findByPrixLocation(double prixLocation);

	
}
