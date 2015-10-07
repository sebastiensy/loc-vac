package fr.uha.miage.locvac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.locvac.model.User;
import fr.uha.miage.locvac.repository.UserRepository;

@Controller
public class CompteController {
	
	@Autowired
	private UserRepository userRepository;
	
	// pour afficher le formulaire
	@RequestMapping(value="/compte", method=RequestMethod.GET)
    public String affichageFormCompte(Model model) {
    	model.addAttribute("user", new User());
    	return "compte";
    }
    
    

}
