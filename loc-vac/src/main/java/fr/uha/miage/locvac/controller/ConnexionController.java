package fr.uha.miage.locvac.controller;

import javax.servlet.http.HttpSession;

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
	public String formInscriptionSubmit(HttpSession session, @ModelAttribute User user, Model model) {
		//model.addAttribute("user", user);
		
		if (userRepository.findByEmailUserAndMdpUser(user.getEmailUser(), user.getMdpUser()) != null)
		{
			System.out.println("ok");
		}
		else
		{
			System.out.println("pas bon");
		}
			
		
		
		return "connexion";
	}
}
