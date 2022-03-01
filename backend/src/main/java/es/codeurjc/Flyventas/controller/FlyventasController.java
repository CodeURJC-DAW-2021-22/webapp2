package es.codeurjc.Flyventas.controller;


//import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Hay que meter los repositorios de las bbdd @Autowired

@Controller
public class FlyventasController {
	
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
	 public String busqueda(Model model, @RequestParam String search) {

		 //List<Product> resultTitle = productService.findByTitle(search);
		 model.addAttribute("search", search);
		 //model.addAttribute("title", resultTitle.get(0).getTitle());
		 return "busqueda";
	 }
	 @GetMapping("/busqueda/{id}")
	 public String busquedaid(Model model, @PathVariable long id) {
		 
		// model.addAttribute("name", "World");
		 
		 return "busqueda";
	 }
	 @GetMapping("/registro2")
	 public String registro2(Model model) {
		 
		// model.addAttribute("name", "World");
		 
		 return "registro2";
	 }
	 
	 @GetMapping("/perfil")
	 public String perfil() {
		 
		 
		 return "perfil";
	 }

	@GetMapping("/subirProducto")
	public String subirProducto() {


		return "subirProducto";
	}

	 
}


