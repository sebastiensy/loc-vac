package fr.uha.miage.locvac.repository;

import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.locvac.model.Equipement;

public interface EquipementRepository extends CrudRepository<Equipement, Integer>{

	public Equipement findByNomEquipement(String nomEquipement);
	public Equipement findByIdEquipement(int idEquipement);
	
}