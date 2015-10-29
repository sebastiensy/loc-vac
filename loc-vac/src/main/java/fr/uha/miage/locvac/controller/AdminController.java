package fr.uha.miage.locvac.controller;

import java.util.ArrayList;
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

import fr.uha.miage.locvac.model.Equipement;
import fr.uha.miage.locvac.model.Location;
import fr.uha.miage.locvac.model.Reserver;
import fr.uha.miage.locvac.model.TypeLit;
import fr.uha.miage.locvac.model.TypePropriete;
import fr.uha.miage.locvac.model.TypeSdb;
import fr.uha.miage.locvac.model.User;
import fr.uha.miage.locvac.repository.EquipementRepository;
import fr.uha.miage.locvac.repository.LocationRepository;
import fr.uha.miage.locvac.repository.ReserverRepository;
import fr.uha.miage.locvac.repository.TypeLitRepository;
import fr.uha.miage.locvac.repository.TypeProprieteRepository;
import fr.uha.miage.locvac.repository.TypeSdbRepository;
import fr.uha.miage.locvac.repository.UserRepository;

@Controller
public class AdminController {
	
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
	
	
	/*@RequestMapping("/admin/header")
    public String afficheHeaderAdmin() {
        return "/admin/header";
    }*/
	@RequestMapping("/admin/menu")
    public String afficheMenuAdmin() {
        return "/admin/menu";
    }
	@RequestMapping("/admin/index")
    public String afficheIndexAdmin() {
        return "/admin/index";
    }
	
	@RequestMapping("/admin/tableusers")
    public String afficheUsers() {
        return "/admin/tableusers";
    }
	
	@RequestMapping("/admin/reservations")
    public String afficheReservations() {
        return "/admin/reservations";
    }
	
	
	
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
	public String creerLocation(Location location, @ModelAttribute("typeProprietes") TypePropriete typePropriete, Model model) {
		
		String option = typePropriete.getNomTypePropriete();
		locationRepository.save(location);
		System.out.println(locationRepository.findAll());
		System.out.println(option);
		return "redirect:/admin/creerlocation";
		
	}
	
	// pour afficher les locations
	@RequestMapping("/admin/afficherlocations")
    public String afficheLocations() {
        return "/admin/afficherlocations";
    }

	
	
	
	
	
	
	
	
	
	/*
	 * PAGE EQUIPEMENTS
	 */
	
	// pour afficher la page equipements
	@RequestMapping(value="/admin/equipements", method=RequestMethod.GET)
    public String afficheEquipements(Model model) {
		
		// pour initialiser le formulaire
		model.addAttribute("equipement", new Equipement());
			
		// pour afficher dans le tableau la liste des equipements
		List<Equipement> equipements = (List<Equipement>) equipementRepository.findAll();
		model.addAttribute("equipements", equipements);
        return "/admin/equipements";
    }
	
	// pour sauvegarder un equipement dans le repository
	@RequestMapping(value="/admin/equipements", method=RequestMethod.POST)
    public String sauveEquipement(Equipement equipement) {
		
		equipementRepository.save(equipement);
		//System.out.println(equipementRepository.findAll());
		return "redirect:/admin/equipements";
    }
	
	// pour pouvoir supprimer un equipement grâce à son id
	@RequestMapping("/supprimerEquipement/{idEquipement}")
	public String supprimeEquipement(@PathVariable("idEquipement") Integer idEquipement) {
		
		equipementRepository.delete(idEquipement);
		return "redirect:/admin/equipements";
	}
	
	
	/*
	 * PAGE TYPE PROPRIETE
	 */
	
	// pour afficher la page type proprietes
	@RequestMapping(value="/admin/typeproprietes", method=RequestMethod.GET)
    public String afficheTypeProprietes(Model model) {
		
		// pour initialiser le formulaire
		model.addAttribute("typePropriete", new TypePropriete());
			
		// pour afficher dans le tableau la liste des types proprietes
		List<TypePropriete> typeProprietes = (List<TypePropriete>) typeProprieteRepository.findAll();
		model.addAttribute("typeProprietes", typeProprietes);
        return "/admin/typeproprietes";
    }
	
	// pour sauvegarder un type de propriete dans le repository
	@RequestMapping(value="/admin/typeproprietes", method=RequestMethod.POST)
    public String sauveEquipement(TypePropriete typePropriete) {
		
		typeProprieteRepository.save(typePropriete);
		System.out.println(typeProprieteRepository.findAll());
		return "redirect:/admin/typeproprietes";
    }
	
	// pour pouvoir supprimer un type de propriete grâce à son id
	@RequestMapping("/supprimerTypePropriete/{idTypeProp}")
	public String supprimeTypePropriete(@PathVariable("idTypeProp") Integer idTypeProp) {
		
		typeProprieteRepository.delete(idTypeProp);
		return "redirect:/admin/typeproprietes";
	}
	
	
	/*
	 * PAGE TYPE SALLE DE BAIN
	 */
	
	// pour afficher la page type salle de bain
	@RequestMapping(value="/admin/typesdb", method=RequestMethod.GET)
    public String afficheTypeSdb(Model model) {
		
		// pour initialiser le formulaire
		model.addAttribute("typeSdb", new TypeSdb());
			
		// pour afficher dans le tableau la liste des types salle de bain
		List<TypeSdb> typeSdbs = (List<TypeSdb>) typeSdbRepository.findAll();
		model.addAttribute("typeSdbs", typeSdbs);
        return "/admin/typesdb";
    }
	
	// pour sauvegarder un type de salle de bain dans le repository
	@RequestMapping(value="/admin/typesdb", method=RequestMethod.POST)
    public String sauveTypeSdb(TypeSdb typeSdb) {
		
		typeSdbRepository.save(typeSdb);
		System.out.println(typeSdbRepository.findAll());
		return "redirect:/admin/typesdb";
    }
	
	// pour pouvoir supprimer un type de salle de bain grâce à son id
	@RequestMapping("/supprimerTypeSdb/{idTypeSdb}")
	public String supprimeTypeSdb(@PathVariable("idTypeSdb") Integer idTypeSdb) {
		
		typeSdbRepository.delete(idTypeSdb);
		return "redirect:/admin/typesdb";
	}
	
	
	
	
	
	
	
	
	/*
	 * PAGE TYPE LIT
	 */
	
	// pour afficher la page type lit
	@RequestMapping(value="/admin/typelit", method=RequestMethod.GET)
    public String afficheTypeLit(Model model) {
		
		// pour initialiser le formulaire
		model.addAttribute("typeLit", new TypeLit());
			
		// pour afficher dans le tableau la liste des types de lits 
		List<TypeLit> typeLits = (List<TypeLit>) typeLitRepository.findAll();
		model.addAttribute("typeLits", typeLits);
        return "/admin/typelit";
    }
	
	// pour sauvegarder un type de lit dans le repository
	@RequestMapping(value="/admin/typelit", method=RequestMethod.POST)
    public String sauveTypeLit(TypeLit typeLit) {
		
		typeLitRepository.save(typeLit);
		System.out.println(typeLitRepository.findAll());
		return "redirect:/admin/typelit";
    }
	
	// pour pouvoir supprimer un type de lit grâce à son id
	@RequestMapping("/supprimerTypeLit/{idTypeLit}")
	public String supprimeTypeLit(@PathVariable("idTypeLit") Integer idTypeLit) {
		
		typeLitRepository.delete(idTypeLit);
		return "redirect:/admin/typelit";
	}
	
	
	
	
	
	/*
	 * PAGE UTILISATEUR 
	 */
	
	// pour afficher la page user
	@RequestMapping(value="/admin/tableusers", method=RequestMethod.GET)
    public String afficheUser(Model model) {
		
		// pour initialiser le formulaire
		//model.addAttribute("user", new User());
			
		// pour afficher dans le tableau la liste des utilisateurs 
		List<User> users = (List<User>) userRepository.findAll();
		model.addAttribute("users", users);
        return "/admin/tableusers";
    }
	
	
	
	
	/*
	 * PAGE UTILISATEUR 
	 */
	
	// pour afficher la page user
	@RequestMapping(value="/admin/reservation", method=RequestMethod.GET)
    public String afficheReservation(Model model) {
		
		// pour initialiser le formulaire
		//model.addAttribute("reserver", new Reserver());
			
		// pour afficher dans le tableau la liste des utilisateurs 
		List<Reserver> reservers = (List<Reserver>) reserverRepository.findAll();
		model.addAttribute("reservers", reservers);
        return "/admin/reservation";
    }
	
	
	
	

}


