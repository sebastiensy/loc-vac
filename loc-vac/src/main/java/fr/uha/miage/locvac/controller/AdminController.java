package fr.uha.miage.locvac.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.locvac.model.Equipement;

@Controller
public class AdminController {

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
	
	@RequestMapping(value="/admin/equipements", method=RequestMethod.GET)
    public String afficheFormEquipement(HttpSession session, Equipement equipement) {
        return "/admin/equipements";
    }
	
	@RequestMapping(value="/admin/equipements", method=RequestMethod.POST)
    public String afficheEquipement(HttpSession session, Equipement equipement, BindingResult bindingResult) {
		List<Equipement> cart = (List<Equipement>) session.getAttribute("cart");
    	if (cart == null)
     		cart = new ArrayList<Equipement>();
    	
    	if (!bindingResult.hasErrors())
    		cart.add(equipement);
   	
		session.setAttribute("cart", cart);
		return "/admin/equipements";
    }

}


