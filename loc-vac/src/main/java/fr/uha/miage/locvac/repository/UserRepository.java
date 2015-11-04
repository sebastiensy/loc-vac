package fr.uha.miage.locvac.repository;

import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.locvac.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	public User findByEmailUserAndMdpUser(String emailUser, String mdpUser);
	public User findByNomUser(String nomUser);
	public User findByEmailUser(String emailUser);
	public User findByMdpUser(String mdpUser);
	public User findByIdUser(int idUser);
	
	
	
}
