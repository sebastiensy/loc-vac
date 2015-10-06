package fr.uha.miage.locvac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.locvac.model.User;

@Controller
public class InscriptionController {
	
	// pour afficher le formulaire
	@RequestMapping(value="/inscription", method=RequestMethod.GET)
    public String affichageFormInscription(Model model) {
    	model.addAttribute("user", new User());
    	return "inscription";
    }
    
	
	// bouton submit du formulaire
    @RequestMapping(value="/inscription", method=RequestMethod.POST)
    public String formInscriptionSubmit(@ModelAttribute User user, Model model) {
    	model.addAttribute("user", user);
    	return "inscription";
    }
    

}
