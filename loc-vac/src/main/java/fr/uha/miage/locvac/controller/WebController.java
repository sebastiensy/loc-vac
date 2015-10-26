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

    /*@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }*/
	
	@Autowired
	private UserRepository userRepository;
    
    @RequestMapping("/admin/greeting")
    public String greeting() {
        return "greeting";
    }
    
    @RequestMapping("/index")
    public String index() {
    	System.out.println(userRepository.findAll());
    	return "index";
    }
    
    @RequestMapping("/destinations")
    public String destionations() {
    	return "destinations";
    }
    
    @RequestMapping("/criuses")
    public String criuses() {
    	return "criuses";
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
