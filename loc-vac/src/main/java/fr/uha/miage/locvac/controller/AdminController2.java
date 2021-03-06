package fr.uha.miage.locvac.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.locvac.model.Chaine;
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
	public String creerLocation(Location location, Equipement equipement, TypeSdb typeSdb, HttpSession session) {
		
		// sauvegarder un equipement dans une location
		List<Equipement> listeEquipements = new ArrayList<>();
		listeEquipements.add(equipement);
		System.out.println(location.getEquipements());
				
		// sauvegarder un type sdb dans une location
		List<TypeSdb> listeTypeSdbs = new ArrayList<>();
		listeTypeSdbs.add(typeSdb);
		System.out.println(location.getTypeSdbs());
				
		locationRepository.save(location);
		
		//System.out.println(locationRepository.findAll());
		
		// recuperation de l'id location
		int idLoc = location.getIdLocation();
		
		// enregistrement de l'id location en session
		session.setAttribute("idLoc", idLoc);
		
		return "redirect:/admin/creerlocationdatedispo";
		
	}
	
	// pour afficher la page creerlocation
		@RequestMapping("/admin/creerlocationdatedispo")
	    public String afficheFormCreerLocationDateDispo(Model model, HttpSession session) {
			
			// pour intialiser une location
			model.addAttribute("chaine", new Chaine());
			
			
			// pour afficher dans le tableau la liste des date dispo
			//List<DateDispo> dateDispos = (List<DateDispo>) dateDispoRepository.findAll();
			
			// recuperation de l'id location avec la session
			int idLoc = (int) session.getAttribute("idLoc");
			
			// affichage du nom de locotion courante
			model.addAttribute("location", locationRepository.findOne(idLoc));
			
			// affichage des dates dispos de la location courante
			List<DateDispo> dateDispos = (List<DateDispo>) locationRepository.findByIdLocation(idLoc).getDateDispo();
			model.addAttribute("dateDispos", dateDispos);
			
	        return "/admin/creerlocationdatedispo";
	    }
		
		// pour sauvegarder une date dans le repository
		@RequestMapping(value="/admin/creerlocationdatedispo", method=RequestMethod.POST)
	    public String sauveDateDispo(Chaine chaine, HttpSession session) throws ParseException {
			
		
					
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			
			Date d = sdf.parse(chaine.getDebut());
			Date d2 = sdf.parse(chaine.getFin());
			
			
			DateDispo dateDispo = new DateDispo();
			dateDispo.setDateDebut(d);
			dateDispo.setDateFin(d2);
			
			// recuperation de l'id location avec la session
			int idLoc = (int) session.getAttribute("idLoc");
			System.out.println("id loc = " + idLoc);
			
			// association de la date dispo avec la location courante
			dateDispo.setLocationDateDispo(locationRepository.findOne(idLoc));
			
			// association de la location avec la date dispo
			List<DateDispo> listeDateDispo = new ArrayList<>();
			listeDateDispo.add(dateDispo);
			locationRepository.findOne(idLoc).setDateDispo(listeDateDispo);
			
			dateDispoRepository.save(dateDispo);
			
			return "redirect:/admin/creerlocationdatedispo";
	    }
	
	
	
		@RequestMapping("/supprimerDateDispo/{idDateDispo}")
		public String supprimeDateDispo(@PathVariable("idDateDispo") Integer idDateDispo) {
			dateDispoRepository.delete(idDateDispo);
			return "redirect:/admin/creerlocationdatedispo";
		}
			
	
	
	

}


