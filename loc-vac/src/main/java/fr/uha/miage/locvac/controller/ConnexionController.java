package fr.uha.miage.locvac.controller;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.locvac.model.User;
import fr.uha.miage.locvac.repository.UserRepository;

@Controller
public class ConnexionController {

	@Autowired
	private UserRepository userRepository;
	
	// pour afficher le formulaire de connexion
	@RequestMapping(value="/connexion", method=RequestMethod.GET)
	public String affichageFormConnexion(HttpSession session, Model model) {
		model.addAttribute("user", new User());
		return "connexion";
	}


	// bouton submit du formulaire
	@RequestMapping(value="/connexion", method=RequestMethod.POST)
	public String connexion(HttpSession session, @ModelAttribute User user, Model model) {
		
		// suppression du message d'erreur
		session.removeAttribute("msgerreur");
		
		// initialise un idUser, nomUser et prenomUser
		int idUser;
		String nomUser;
		String prenomUser;
		
		if (userRepository.findByEmailUser(user.getEmailUser()).getEmailUser() == "admin@admin.com") {
			System.out.println("admin email");
        	if (BCrypt.checkpw(user.getMdpUser(), userRepository.findByEmailUser(user.getEmailUser()).getMdpUser()))
        	{
        		return "redirect:/admin/index";
        	}
		}
		// on cherche si il y a un email qui correspond à un user dans le repository
    	if (userRepository.findByEmailUser(user.getEmailUser()) != null) 
    	{    		
    		// Vérification d'un mot de passe à partir du hash
        	if (BCrypt.checkpw(user.getMdpUser(), userRepository.findByEmailUser(user.getEmailUser()).getMdpUser()))
        	{
        		System.out.println("mdp ok");
        		//System.out.println("hash dans le repo : " + userRepository.findByEmailUser(user.getEmailUser()).getMdpUser());
        		
        		// recuperation de l'id de l'user connecté
        		idUser = userRepository.findByEmailUser(user.getEmailUser()).getIdUser();
        		
        		// recuperation du nom et prénom de l'user connecté
    			nomUser = userRepository.findByEmailUser(user.getEmailUser()).getNomUser();
    			prenomUser = userRepository.findByEmailUser(user.getEmailUser()).getPrenomUser();

        		// mises en session de l'id de l'user connecté et du nom et prenom
        		session.setAttribute("auth", idUser);
    			session.setAttribute("nomprenom", prenomUser + " " + nomUser);
    			
    			// suppression du message d'erreur
        		session.removeAttribute("msgerreur");

        		return "redirect:/index";
        	}
        	else
        	{
        		System.out.println("mdp faux");
        		session.setAttribute("msgerreur", "Le mot de passe que vous avez saisi est incorrect !");
        		return "connexion";
        	}
    	}
    	else
		{
    		System.out.println("pas de user avec cette adresse email");
    		session.setAttribute("msgerreur", "L'adresse email n'est pas valide !");
    		return "connexion";
		}
	}
	
	// pour se déconnecter
	@RequestMapping(value="/deconnexion", method=RequestMethod.GET)
	public String deconnexion(HttpSession session) {
		session.removeAttribute("auth");
		return "redirect:/index";
	}
}
