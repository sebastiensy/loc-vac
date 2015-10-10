package fr.uha.miage.locvac.repository;

import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.locvac.model.TypePropriete;

public interface TypeProprieteRepository extends CrudRepository<TypePropriete, Integer>{

	public TypePropriete findByIdTypeProp(int idTypeProp);
	public TypePropriete findByNomTypePropriete(String nomTypePropriete);

}