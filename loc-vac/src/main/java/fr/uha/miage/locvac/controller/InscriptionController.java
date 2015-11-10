package fr.uha.miage.locvac.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.locvac.model.User;
import fr.uha.miage.locvac.repository.UserRepository;

@Controller
public class InscriptionController {
	
	@Autowired
	private UserRepository userRepository;
	
	// pour afficher le formulaire
	@RequestMapping(value="/inscription", method=RequestMethod.GET)
    public String affichageFormInscription(Model model) {
    	model.addAttribute("user", new User());
    	return "inscription";
    }
    
	
	// bouton submit du formulaire
    @RequestMapping(value="/inscription", method=RequestMethod.POST)
    public String formInscriptionSubmit(@Valid User user, BindingResult bindingResult, HttpSession session) {
    	
       	if (bindingResult.hasErrors())
       		return "inscription";
       	
       	// initialise un idUser, nomUser et prenomUser
     		int idUser;
     		String nomUser;
     		String prenomUser;
     		
       	// verification que l'email saisi n'est pas déjà utilisé
       	if (userRepository.findByEmailUser(user.getEmailUser()) == null)
       	{
       		// Hashage d'un mot de passe
	    	// Il est possible d'augmenter la complexité (et donc le temps
	    	// de traitement) en passant le "workfactor" en paramètre
	    	// ici : 12 La valeur par défaut est 10
	    	String hashed = BCrypt.hashpw(user.getMdpUser(), BCrypt.gensalt(12));
	    	
	    	// enregistrement du mdp hashé dans le repository
	    	user.setMdpUser(hashed);
	    	
	    	// sauvegarde l'user dans le repository
	    	userRepository.save(user);
	    	
	    	// recuperation de l'id de l'user connecté
    		idUser = userRepository.findByEmailUser(user.getEmailUser()).getIdUser();
    		
    		// recuperation du nom et prénom de l'user connecté
			nomUser = userRepository.findByEmailUser(user.getEmailUser()).getNomUser();
			prenomUser = userRepository.findByEmailUser(user.getEmailUser()).getPrenomUser();

    		// mises en session de l'id de l'user connecté et du nom et prenom
    		session.setAttribute("auth", idUser);
			session.setAttribute("nomprenom", prenomUser + " " + nomUser);
	    	
	    	return "redirect:/index";
       	}
       	else
       	{
       		return "inscription";
       	}
    	
    	
    }
    

}
