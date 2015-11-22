package fr.uha.miage.locvac.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.locvac.model.DateDispo;
import fr.uha.miage.locvac.model.Equipement;
import fr.uha.miage.locvac.model.Location;
import fr.uha.miage.locvac.model.Reserver;
import fr.uha.miage.locvac.model.TypeSdb;
import fr.uha.miage.locvac.repository.ChambreRepository;
import fr.uha.miage.locvac.repository.DateDispoRepository;
import fr.uha.miage.locvac.repository.EquipementRepository;
import fr.uha.miage.locvac.repository.LocationRepository;
import fr.uha.miage.locvac.repository.ReserverRepository;
import fr.uha.miage.locvac.repository.TypeSdbRepository;
import fr.uha.miage.locvac.repository.UserRepository;

@Controller
public class LocationController {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private EquipementRepository equipementRepository;
	
	@Autowired
	private TypeSdbRepository typeSdbRepository;
	
	@Autowired
	private ChambreRepository chambreRepository;
	
	@Autowired
	private DateDispoRepository dateDispoRepository;
	
	@Autowired
	private ReserverRepository reserverRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	// pour afficher la page location user
	@RequestMapping(value="/destinations", method=RequestMethod.GET)
    public String afficheLocation(Model model) {
		
		// pour afficher dans le tableau la liste des locations 
		List<Location> locations = (List<Location>) locationRepository.findAll(); 
		model.addAttribute("locations", locations);
		
		List<Location> locationss = (List<Location>) locationRepository.findAll(); 
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
		
		// pour afficher la liste des dates dispos
		List<DateDispo> dateDispos = (List<DateDispo>) locationRepository.findOne(idLocation).getDateDispo();
		model.addAttribute("dateDispos", dateDispos);
		
		// pour initialiser les champs dates
		model.addAttribute("reserver", new Reserver());
		
		
		session.setAttribute("idloc", idLocation);
		//System.out.println(locationRepository.findOne(idLocation));
		return "detaildest";
    }
	
	@RequestMapping(value="/detaildest", method=RequestMethod.POST)
    public String creerReservation(Reserver reserver, Model model, HttpSession session) {
		
		// reservation pour l'user connecté
		System.out.println("iduser : " +  session.getAttribute("auth"));
		int idUser = (int) session.getAttribute("auth");
		reserver.setUserReserver(userRepository.findOne(idUser));
		
		// reservation de la location courante
		System.out.println("idloc : " +  session.getAttribute("idloc"));
		int idLoc = (int) session.getAttribute("idloc");
		reserver.setLocationReserver(locationRepository.findOne(idLoc));
		
		
		// calcul du prix de la location en fonction du nb de jours de reservation
		long diff = reserver.getDateFinReserver().getTime() - reserver.getDateDebutReserver().getTime();
	    long nbJoursReserv = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		double prixLoc = nbJoursReserv * locationRepository.findOne(idLoc).getPrixLocation();
		reserver.setPrixReserver(prixLoc);
		
		// verification si dates de reservation comprises entre date dispo
		List<DateDispo> listeDateDispo = locationRepository.findOne(idLoc).getDateDispo();
		Iterator i = listeDateDispo.iterator();
		
		
		
		reserverRepository.save(reserver);
		
		
		return "redirect:/recapreserver";
    }
	
	
	
	
	// pour afficher la page location user
	@RequestMapping(value="/recapreserver", method=RequestMethod.GET)
    public String afficheRecapReserver(Model model) {
		
		//System.out.println(reserverRepository.findAll());
		/*// pour afficher dans le tableau la liste des locations 
		List<Location> locations = (List<Location>) locationRepository.findAll(); 
		System.out.println(locations);
		model.addAttribute("locations", locations);
		
		List<Location> locationss = (List<Location>) locationRepository.findAll(); 
		System.out.println(locationss);
		model.addAttribute("locationss", locationss);
		
		System.out.println(chambreRepository.findAll());*/
        return "recapreserver";
    }
	
	
	
	
	


}
