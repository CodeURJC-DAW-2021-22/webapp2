package es.codeurjc.Flyventas.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Controladorlogin {
	
	 @GetMapping("/")
	 public String main(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "index";
	 }
	 @GetMapping("/busqueda/") 
	 public String busqueda(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "busqueda";
	 }
	 @GetMapping("/login")
	 public String login(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "login";
	 }
	 @GetMapping("/p")
	 public String producto(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "Producto";
	 }
	 @GetMapping("/registro")
	 public String registro(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "Registro";
	 }
}


