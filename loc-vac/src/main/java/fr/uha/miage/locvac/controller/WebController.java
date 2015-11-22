package fr.uha.miage.locvac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.uha.miage.locvac.model.User;
import fr.uha.miage.locvac.repository.UserRepository;

@Controller
public class WebController {

   	
	@Autowired
	private UserRepository userRepository;
    
    @RequestMapping("/admin/greeting")
    public String greeting() {
        return "greeting";
    }
    
    @RequestMapping("/index")
    public String index() {
    	return "index";
    }
    
    
    
    
    
    @RequestMapping("/contact")
    public String contact() {
    	return "contact";
    }
    
    @RequestMapping("/blog")
    public String blog() {
    	return "blog";
    }

}
