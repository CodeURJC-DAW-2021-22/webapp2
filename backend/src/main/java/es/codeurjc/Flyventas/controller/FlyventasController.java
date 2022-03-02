package es.codeurjc.Flyventas.controller;


//import java.util.Optional;

import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.repository.ProductRepository;
import es.codeurjc.Flyventas.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Hay que meter los repositorios de las bbdd @Autowired



@Controller
public class FlyventasController {

	@Autowired
	private ProductServices productServices;
	
	 @GetMapping("/")
	 public String main(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "index";
	 }
	 @GetMapping("/index.html")
	 public String main2(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "index";
	 }
	 
	 
	 @GetMapping("/login")
	 public String login(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "login";
	 }
	 @GetMapping("/login.html")
	 public String login2(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "login";
	 }
	 @GetMapping("/Registro.html")
	 public String Registro(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "Registro";
	 }
	
	 /*
	 @GetMapping("/producto/{id}")
	 public String producto(Model model, @PathVariable long id) {
		 Optional<Product> Product = servicio.findById(id);
			if (Product.isPresent()) {
				model.addAttribute("product", product.get());
				return "product";
			} else {
				return "index";
			}
		// model.addAttribute("name", "World");
		 
		 return "Producto";
		 	 
	 }
	 */
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
			return "busqueda";
		} else {
			return "searchnotfound";
		}
	 }
	 @GetMapping("/registro2")
	 public String registro2 (Model model){

		 // model.addAttribute("name", "World");

		 return "registro2";
	 }

	 @GetMapping("/perfil")
	 public String perfil () {


		 return "perfil";
	 }

	 @GetMapping("/subirProducto")
	 public String subirProducto() {


		return "subirProducto";
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


