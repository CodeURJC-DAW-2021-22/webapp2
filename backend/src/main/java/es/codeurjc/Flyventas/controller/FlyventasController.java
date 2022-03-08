package es.codeurjc.Flyventas.controller;


//import java.util.Optional;

import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.User;
import es.codeurjc.Flyventas.repository.ProductRepository;
import es.codeurjc.Flyventas.services.ProductServices;
import es.codeurjc.Flyventas.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

//Hay que meter los repositorios de las bbdd @Autowired



@Controller
public class FlyventasController {

	@ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		if(principal != null) {
			model.addAttribute("logged", true);
			model.addAttribute("username", principal.getName());
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
		} else {
			model.addAttribute("logged", false);
		}
	}

	@Autowired
	private ProductServices productServices;
	@Autowired
	private UserServices userServices;
	
	 @GetMapping("/")
	 public String main(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "index";
	 }
	 
	 @GetMapping("/login")
	 public String login(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "login";
	 }

	@GetMapping("/loginerror")
	public String loginerror(Model model) {

		return "loginerror";
	}

	@GetMapping("/logout")
	public String logout(Model model) {

		return "logout";
	}

	 @GetMapping("/register")
	 public String register(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "Registro";
	 }

	 @RequestMapping("/busqueda")
	 public String busqueda(Model model, @RequestParam String title) {

		 Optional<Product> Product = productServices.findByTitle(title);
		 model.addAttribute("search", title);
		 if (Product.isPresent()) {
			 model.addAttribute("Product", Product.get());
			 return "busqueda";
		 } else {
			 return "searchnotfound";
		 }
	 }

	@RequestMapping("/category/{category}")
	public String CategorySearch(Model model, @PathVariable String category) {

		Optional<Product> Product = productServices.findByCategory(category);
		model.addAttribute("search", category);
		if (Product.isPresent()) {
			model.addAttribute("Product", Product.get());
			return "/busqueda";
		} else {
			return "/searchnotfound";
		}
	 }
	 @GetMapping("/registro2")
	 public String registro2 (Model model){

		 // model.addAttribute("name", "World");

		 return "registro2";
	 }


	 @GetMapping("/subirProducto")
	 public String subirProducto() {


		return "subirProducto";
	 }

	@GetMapping("/perfil/{id}")
	public String perfil(Model model, @PathVariable long id) {

		Optional<User> Profile = userServices.findUserById(id);
		if (Profile.isPresent()) {
			model.addAttribute("name", Profile.get().getName());
			model.addAttribute("email", Profile.get().getEmail());
			model.addAttribute("address", Profile.get().getAddress());
			return "perfil";
		} else {
			return "searchnotfound";
		}

	}


	 @GetMapping("/Producto/{id}")
		public String showProduct(Model model, @PathVariable long id) {
		 
		 Optional<Product> Product = productServices.findById(id);
			if (Product.isPresent()) {
				model.addAttribute("Product", Product.get());
				return "Producto";
			} else {
				return "searchnotfound";
			}
		 
	 }


}


