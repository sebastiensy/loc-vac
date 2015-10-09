package fr.uha.miage.locvac.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.locvac.model.Equipement;
import fr.uha.miage.locvac.repository.EquipementRepository;

@Controller
public class AdminController {
	
	@Autowired
	private EquipementRepository equipementRepository;

	@RequestMapping("/admin/index")
    public String afficheIndexAdmin() {
        return "/admin/index";
    }
	
	@RequestMapping("/admin/tableusers")
    public String afficheUsers() {
        return "/admin/tableusers";
    }
	
	@RequestMapping("/admin/creerlocation")
    public String afficheFormCreerLocation() {
        return "/admin/creerlocation";
    }
	

	@RequestMapping("/admin/reservations")
    public String afficheReservations() {
        return "/admin/reservations";
    }
	
	
	@RequestMapping("/admin/afficherlocations")
    public String afficheLocations() {
        return "/admin/afficherlocations";
    }
	
	
	/*
	 * Equipement
	 */
	@RequestMapping(value="/admin/equipements", method=RequestMethod.GET)
    public String afficheFormEquipement(Model model) {
		model.addAttribute("equipement", new Equipement());
        return "/admin/equipements";
    }
	
	@RequestMapping(value="/admin/equipements", method=RequestMethod.POST)
    public String sauveEquipement(Equipement equipement) {
		
		equipementRepository.save(equipement);
		System.out.println(equipementRepository.findAll());
		return "/admin/equipements";
    }
	
	@RequestMapping(value="/admin/equipements")
    public String afficheEquipement(Model model) {
		System.out.println("test");
		List<Equipement> equipements = (List<Equipement>) equipementRepository.findAll();
		model.addAttribute("equipements", equipements);
		return "/admin/equipements";
    }

}


