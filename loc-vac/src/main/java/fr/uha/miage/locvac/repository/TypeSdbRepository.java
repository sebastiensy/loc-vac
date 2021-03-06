package fr.uha.miage.locvac.repository;

import org.springframework.data.repository.CrudRepository;
import fr.uha.miage.locvac.model.TypeSdb;

public interface TypeSdbRepository extends CrudRepository<TypeSdb, Integer>{

	public TypeSdb findByIdTsdb(int idTsdb);
	public TypeSdb findByNomTsdb(String nomTsdb);
}