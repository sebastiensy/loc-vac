package fr.uha.miage.locvac.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.locvac.model.DateDispo;
import fr.uha.miage.locvac.model.Equipement;
import fr.uha.miage.locvac.model.Location;
import fr.uha.miage.locvac.model.Reserver;
import fr.uha.miage.locvac.model.TypeLit;
import fr.uha.miage.locvac.model.TypePropriete;
import fr.uha.miage.locvac.model.TypeSdb;
import fr.uha.miage.locvac.model.User;
import fr.uha.miage.locvac.repository.DateDispoRepository;
import fr.uha.miage.locvac.repository.EquipementRepository;
import fr.uha.miage.locvac.repository.LocationRepository;
import fr.uha.miage.locvac.repository.ReserverRepository;
import fr.uha.miage.locvac.repository.TypeLitRepository;
import fr.uha.miage.locvac.repository.TypeProprieteRepository;
import fr.uha.miage.locvac.repository.TypeSdbRepository;
import fr.uha.miage.locvac.repository.UserRepository;

@Controller
public class AdminController2 {
	
	@Autowired
	private EquipementRepository equipementRepository;
	
	@Autowired
	private TypeProprieteRepository typeProprieteRepository;
	
	@Autowired
	private TypeSdbRepository typeSdbRepository;
	
	@Autowired
	private TypeLitRepository typeLitRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	
	@Autowired
	private ReserverRepository reserverRepository;
	
	@Autowired
	private DateDispoRepository dateDispoRepository;
		
	
	/*
	 * 	PAGE LOCATION
	 */
	
	// pour afficher la page creerlocation
	@RequestMapping("/admin/creerlocation")
    public String afficheFormCreerLocation(Model model) {
		
		// pour intialiser une location
		model.addAttribute("location", new Location());
		
		// pour afficher la liste des equipements
		List<Equipement> equipements = (List<Equipement>) equipementRepository.findAll();
		model.addAttribute("equipements", equipements);
		
		// pour afficher la liste des types de propriete
		List<TypePropriete> typeProprietes = (List<TypePropriete>) typeProprieteRepository.findAll();
		model.addAttribute("typeProprietes", typeProprietes);
		
		// pour afficher la liste des types de salle de bain
		List<TypeSdb> typeSdbs = (List<TypeSdb>) typeSdbRepository.findAll();
		model.addAttribute("typeSdbs", typeSdbs);
		
        return "/admin/creerlocation";
    }
	
	// pour creer une location
	@RequestMapping(value="/admin/creerlocation", method=RequestMethod.POST)
	public String creerLocation(Location location) {
		 
		locationRepository.save(location);
		System.out.println(locationRepository.findAll());
		return "redirect:/admin/creerlocationdatedispo";
		
	}
	
	// pour afficher la page creerlocation
		@RequestMapping("/admin/creerlocationdatedispo")
	    public String afficheFormCreerLocationDateDispo(Model model) {
			
			// pour intialiser une location
			model.addAttribute("dateDispo", new DateDispo());
			
			// pour afficher dans le tableau la liste des types proprietes
			List<DateDispo> dateDispos = (List<DateDispo>) dateDispoRepository.findAll();
			model.addAttribute("dateDispos", dateDispos);
			
	        return "/admin/creerlocationdatedispo";
	    }
		
		// pour sauvegarder un type de propriete dans le repository
		@RequestMapping(value="/admin/creerlocationdatedispo", method=RequestMethod.POST)
	    public String sauveDateDispo(DateDispo dateDispo) {
			
			dateDispoRepository.save(dateDispo);
			return "redirect:/admin/creerlocationdatedispo";
	    }
	
	
	
	


	
	
	

}


