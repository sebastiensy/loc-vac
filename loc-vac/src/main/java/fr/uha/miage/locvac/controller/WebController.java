package fr.uha.miage.locvac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    /*@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }*/
    
    @RequestMapping("/greeting")
    public String greeting() {
        return "greeting";
    }
    
    @RequestMapping("/index")
    public String index() {
    	return "index";
    }
    
    @RequestMapping("/inscription")
    public String inscription() {
    	return "inscription";
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
