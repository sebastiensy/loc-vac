package fr.uha.miage.locvac.repository;

import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.locvac.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	
}