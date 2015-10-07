package fr.uha.miage.locvac.repository;

import org.springframework.data.repository.CrudRepository;
import fr.uha.miage.locvac.model.TypeLit;

public interface TypeLitRepository extends CrudRepository<TypeLit, Integer>{

	public TypeLit findByIdTypeLit(int idTypeLit);
	public TypeLit findByNomLit(String nomLit);
	
}