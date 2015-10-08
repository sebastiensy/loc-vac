package fr.uha.miage.locvac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}


