package fr.uha.miage.locvac.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.locvac.model.Equipement;
import fr.uha.miage.locvac.model.TypePropriete;
import fr.uha.miage.locvac.repository.EquipementRepository;
import fr.uha.miage.locvac.repository.TypeProprieteRepository;

@Controller
public class AdminController {
	
	@Autowired
	private EquipementRepository equipementRepository;
	
	@Autowired
	private TypeProprieteRepository typeProprieteRepository;

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
		
		// pour afficher la liste des equipements
		List<Equipement> equipements = (List<Equipement>) equipementRepository.findAll();
		model.addAttribute("equipements", equipements);
        return "/admin/creerlocation";
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
	
	// pour sauvegarder un typepropriete dans le repository
	@RequestMapping(value="/admin/typeproprietes", method=RequestMethod.POST)
    public String sauveEquipement(TypePropriete typePropriete) {
		
		typeProprieteRepository.save(typePropriete);
		System.out.println(typeProprieteRepository.findAll());
		return "redirect:/admin/typeproprietes";
    }
	
	// pour pouvoir supprimer un equipement grâce à son id
	@RequestMapping("/supprimerTypePropriete/{idTypeProp}")
	public String supprimeTypePropriete(@PathVariable("idTypeProp") Integer idTypeProp) {
		
		typeProprieteRepository.delete(idTypeProp);
		return "redirect:/admin/typeproprietes";
	}
	

}


