package fr.uha.miage.locvac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/admin/index")
    public String afficheIndexAdmin() {
        return "/admin/index";
    }
	
	@RequestMapping("/admin/tables")
    public String afficheUsers() {
        return "/admin/tables";
    }
}
