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
	private TransactionRepository transactions;

	@Autowired
	private ProductServices productServices;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private UserServices userServices;

	@Autowired
	private CounterofferRepository counteroffers;

	@Autowired
	private ProductRepository products;


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

		List<Product> Product = productServices.findProductByCategoryPageable(category, PageRequest.of(0,3));
		model.addAttribute("search", category);
		if (!Product.isEmpty()) {
			model.addAttribute("Product", Product);
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

		List<Product> Product = productServices.findProductByCategoryPageable("Otros", PageRequest.of(0,5));
		Optional<User> Profile = userServices.findUserById(id);
		if (Profile.isPresent()) {
			model.addAttribute("Product", Product);
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
	//------------------------------------------------------------------------------------------------------------------

	//Transaction Controller

	@GetMapping("/confirmacionCompra/{id}")
	public String comfirmTransaction(Model model, @PathVariable long id) {

		Optional<Product> Product = productServices.findById(id);
		if (Product.isPresent()) {
			model.addAttribute("Product", Product.get());
			return "compra";
		} else {
			return "searchnotfound";
		}
	}

	@GetMapping("/resumen/{id}/{tokenpayment}")
	public String newTransaction(Model model, HttpServletRequest request, @PathVariable long id, @PathVariable String tokenpayment) {

		Principal principal = request.getUserPrincipal();
		Optional<Product> Product = productServices.findById(id);
		//Before making the transaction, it would be necessary to check if the token that you have sent us through the link is the same as the one that the payment gateway sends us.
		if (Product.isPresent()) {

			Optional<User> User = userServices.findUserByEmail(principal.getName());
			transactions.save(new Transaction(Product.get(), User.get()));

			model.addAttribute("Product", Product.get());

			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo("j.molinero.2019@alumnos.urjc.es");
			email.setSubject("Recibo FlyVentas");
			String str = Long.toString(id);
			String message = ("http://localhost:8080/resumen/"+str+"/12345/?format=pdf");
			email.setText(message);
			mailSender.send(email);

			return "resumen";
		} else {

			return "searchnotfound";
		}
	}
    //------------------------------------------------------------------------------------------------------------------

	//Counteroffer Controller

	@GetMapping("/confirmacionContraoferta/{id}")
	public String confirmCounteroffer(Model model, @PathVariable long id) {

		Optional<Product> Product = productServices.findById(id);
		if (Product.isPresent()) {
			model.addAttribute("Product", Product.get());
			return "contraoferta";
		} else {
			return "searchnotfound";
		}
	}

	@PostMapping("/counteroffer/{id}")
	public String contraoffer(Model model, HttpServletRequest request, @PathVariable long id, @RequestParam float newOffer) {

		Principal principal = request.getUserPrincipal();
		Optional<Product> Product = productServices.findById(id);
		if (Product.isPresent()) {

			Optional<User> User = userServices.findUserByEmail(principal.getName());
			counteroffers.save(new Counteroffer(Product.get(), newOffer, User.get()));

			return "redirect:/";
		} else {
			return "searchnotfound";
		}
	}
	//------------------------------------------------------------------------------------------------------------------

	//Product Controller

	@PostConstruct
	public void init() {

		products.save(new Product( "Honda cbr 125", "Como nueva en Pantoja de la Sagra", "Motos", 1200, false, null));
		products.save(new Product("Camiseta firmada por Hamilton", "Tiene mucho valor sentimental", "Moda", 70, false, null));
		products.save(new Product("3 acciones de Santander", "Se las he robado a mi padre", "Otros", 25000, false, null));
		products.save(new Product("Promo en tiktok", "soy famoso", "Otros", 200, false, null));
		products.save(new Product("Riñon derecho", "urge venderlo para pagar la gasolina de mi bmw", "Otros", 350, false, null));
	}

	@PostMapping("/subirProducto")
	public String newProduct(Model model, HttpServletRequest request, @RequestParam String name, @RequestParam String description, @RequestParam String category, @RequestParam float price){

		Principal principal = request.getUserPrincipal();
		Optional<User> User = userServices.findUserByEmail(principal.getName());
		products.save(new Product(name, description, category, price, false, User.get()));

		return "redirect:/";
	}

}


