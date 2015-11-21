package fr.uha.miage.locvac.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.locvac.model.Equipement;
import fr.uha.miage.locvac.model.Location;
import fr.uha.miage.locvac.model.TypeSdb;
import fr.uha.miage.locvac.repository.EquipementRepository;
import fr.uha.miage.locvac.repository.LocationRepository;
import fr.uha.miage.locvac.repository.TypeSdbRepository;

@Controller
public class LocationController {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private EquipementRepository equipementRepository;
	
	@Autowired
	private TypeSdbRepository typeSdbRepository;
	
	// pour afficher la page location user
	@RequestMapping(value="/destinations", method=RequestMethod.GET)
    public String afficheLocation(Model model) {
		
		// pour afficher dans le tableau la liste des locations 
		List<Location> locations = (List<Location>) locationRepository.findAll(); 
		System.out.println(locations);
		model.addAttribute("locations", locations);
		
		List<Location> locationss = (List<Location>) locationRepository.findAll(); 
		System.out.println(locationss);
		model.addAttribute("locationss", locationss);
        return "destinations";
    }
	
	@RequestMapping("/detaildest/{id}")
    public String afficheDetailLocation(@PathVariable("id") Integer idLocation, Model model, HttpSession session) {
		model.addAttribute("location", locationRepository.findOne(idLocation));
				
		// pour afficher la liste des equipements
		List<Equipement> equipements = (List<Equipement>) equipementRepository.findAll();
		model.addAttribute("equipements", equipements);
		
		// pour afficher la liste des types de sdb
		List<TypeSdb> typeSdbs = (List<TypeSdb>) typeSdbRepository.findAll();
		model.addAttribute("typeSdbs", typeSdbs);
		
		// pour afficher le nombre de salle de bain
		int nbSdb = locationRepository.findOne(idLocation).getTypeSdbs().size();
		model.addAttribute("nbSdb", nbSdb);
		
		System.out.println(locationRepository.findOne(idLocation));
		return "detaildest";
    }


}
