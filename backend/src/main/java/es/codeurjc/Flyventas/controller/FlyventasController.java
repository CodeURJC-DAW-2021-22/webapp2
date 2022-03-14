package es.codeurjc.Flyventas.controller;
//import java.util.Optional;
import es.codeurjc.Flyventas.model.Counteroffer;
import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.Transaction;
import es.codeurjc.Flyventas.model.User;
import es.codeurjc.Flyventas.repository.CounterofferRepository;
import es.codeurjc.Flyventas.repository.ProductRepository;
import es.codeurjc.Flyventas.repository.TransactionRepository;
import es.codeurjc.Flyventas.services.CounterofferServices;
import es.codeurjc.Flyventas.services.ProductServices;
import es.codeurjc.Flyventas.services.TransactionServices;
import es.codeurjc.Flyventas.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
public class FlyventasController {

	@ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		if(principal != null) {
			Optional<User> currentuser = userServices.findUserByEmail(principal.getName());
			model.addAttribute("id", currentuser.get().getId());
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
	private TransactionServices transactionServices;

	@Autowired
	private ProductServices productServices;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private UserServices userServices;

	@Autowired
	private CounterofferRepository counteroffers;

	@Autowired
	private CounterofferServices counterofferServices;

	@Autowired
	private ProductRepository products;


	 @GetMapping("/")
	 public String main(Model model) {
		 
		 return "index";
	 }
	 
	 @GetMapping("/login")
	 public String login(Model model) {

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

		 return "Registro";
	 }

	 @RequestMapping("/busqueda")
	 public String busqueda(Model model, @RequestParam String title) {

		 List<Product> Product = productServices.findByTitle(title, PageRequest.of(0,9));
		 model.addAttribute("search", title);
		 if (!Product.isEmpty()) {
			 model.addAttribute("Results", Product.size());
			 model.addAttribute("Product", Product);
			 return "busqueda";
		 } else {
			 return "searchnotfound";
		 }
	 }

	@RequestMapping("/category/{category}")
	public String CategorySearch(Model model, @PathVariable String category) {

		List<Product> Product = productServices.findProductByCategoryPageable(category, PageRequest.of(0,9));
		model.addAttribute("search", category);
		if (!Product.isEmpty()) {
			model.addAttribute("Results", Product.size());
			model.addAttribute("Product", Product);
			return "/busqueda";
		} else {
			return "/searchnotfound";
		}
	}

	@GetMapping("/Producto/{id}")
	public String showProduct(Model model, @PathVariable long id) {

		Optional<Product> Product = productServices.findById(id);
		if (Product.isPresent()) {

			model.addAttribute("Product", Product.get());
			model.addAttribute("Seller", Product.get().getUser());
			return "Producto";
		} else {

			return "searchnotfound";
		}

	}

	//------------------------------------------------------------------------------------------------------------------

	//Subir Producto y Perfil Controller

	@GetMapping("/subirProducto")
	public String subirProducto() {

		return "subirProducto";
	}

	@GetMapping("/perfilAdmin")
	public String AdminProfile(Model model)  {

		model.addAttribute("Product", productServices.findAll());
		model.addAttribute("Users", userServices.findAll());

		 return "perfilAdmin";
	}

	@GetMapping("/perfil/{id}")
	public String profile(Model model, @PathVariable long id) {

		Optional<User> Profile = userServices.findUserById(id);

		if (Profile.isPresent()) {

			model.addAttribute("Product", productServices.findAllProductsByPublisher(Profile.get(), PageRequest.of(0, 5)));
			model.addAttribute("TransactionsAsBuyer", transactionServices.findByBuyer(Profile.get(), PageRequest.of(0, 5)));
			model.addAttribute("TransactionsAsSeller", transactionServices.findBySeller(Profile.get(), PageRequest.of(0, 5)));
			model.addAttribute("Counteroffers", counterofferServices.findByReceiver(Profile.get(), PageRequest.of(0, 5)));
			model.addAttribute("name", Profile.get().getName());
			model.addAttribute("email", Profile.get().getEmail());
			model.addAttribute("address", Profile.get().getAddress());
			return "perfil";
		} else {

			return "searchnotfound";
		}
	}


	@PostMapping("/editado/{id}")
	public String editProduct(@PathVariable Long id, @RequestParam String title, @RequestParam String category, @RequestParam float price, @RequestParam String description, @RequestParam boolean isSold) {


		Optional<Product> Products = productServices.findById(id);
		if (Products.isPresent()) {
			Product product = Products.get();
			product.setTitle(title);
			product.setCategory(category);
			product.setPrice(price);
			product.setDescription(description);
			product.setIsSold(isSold);
			//editar atributos del objeto
			productServices.save(product);
			return "redirect:/";
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
			transactions.save(new Transaction(Product.get(), User.get(), Product.get().getPrice()));


			model.addAttribute("Product", Product.get());

			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo("j.molinero.2019@alumnos.urjc.es");
			email.setSubject("Recibo FlyVentas");
			String str = Long.toString(id);
			String message = ("https://localhost:8443/resumen/"+str+"/12345/?format=pdf");
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

	@PostMapping("/aceptarContraoferta/{id}")
	public String aceptarContraoferta(HttpServletRequest request, @PathVariable long id) {

	 	Optional<Counteroffer> counterOffer = counterofferServices.findById(id);
	 	if(counterOffer.isPresent()) {

	 		transactions.save(new Transaction(counterOffer.get().getProduct(), counterOffer.get().getTransmitter(), counterOffer.get().getNewPrice()));
	 		counteroffers.delete(counterOffer.get());
		}
	 	return "redirect:/";
	}


	//------------------------------------------------------------------------------------------------------------------

	//Product Controller

	/*@PostConstruct
	public void init() {

		products.save(new Product( "Honda cbr 125", "Como nueva en Pantoja de la Sagra", "Motos", 1200, false, null));
		products.save(new Product("Camiseta firmada por Hamilton", "Tiene mucho valor sentimental", "Moda", 70, false, null));
		products.save(new Product("3 acciones de Santander", "Se las he robado a mi padre", "Otros", 25000, false, null));
		products.save(new Product("Promo en tiktok", "soy famoso", "Otros", 200, false, null));
		products.save(new Product("Riñon derecho", "urge venderlo para pagar la gasolina de mi bmw", "Otros", 350, false, null));
	}*/

	@PostMapping("/subirProducto")
	public String newProduct(Model model, HttpServletRequest request, @RequestParam String name, @RequestParam String description, @RequestParam String category, @RequestParam float price){

		Principal principal = request.getUserPrincipal();
		Optional<User> User = userServices.findUserByEmail(principal.getName());
		products.save(new Product(name, description, category, price, false, User.get()));

		return "redirect:/";
	}

}


