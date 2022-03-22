
package es.codeurjc.Flyventas.controller;



import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.User;

import es.codeurjc.Flyventas.repository.ProductRepository;
import es.codeurjc.Flyventas.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import es.codeurjc.Flyventas.services.CounterofferServices;
import es.codeurjc.Flyventas.services.ProductServices;
import es.codeurjc.Flyventas.services.TransactionServices;
import es.codeurjc.Flyventas.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {
	

	@Autowired
	private UserRepository Users;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TransactionServices transactionServices;

	@Autowired
	private ProductServices productServices;

	@Autowired
	private UserServices userServices;

	@Autowired
	private CounterofferServices counterofferServices;

	@Autowired
	private ProductRepository products;
	
	/*@PostConstruct
    public void init() {
		Users.save(new User("samuel", "rusu" , "s.rusu.2019@gmail.com", "El Toboso 13", passwordEncoder.encode("toboso13"), "moda", "informatica", "automoviles", "ADMIN"));
	}*/

	@PostMapping("/perfil")
	public  String newuser(@RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam String address, @RequestParam String encodedPassword, @RequestParam String category1, @RequestParam String category2, @RequestParam String category3) {
		User admin = new User(name, surname, email, address, passwordEncoder.encode(encodedPassword), category1, category2, category3, "USER");
		Users.save(admin);
		
		return "redirect:/perfil/" + admin.getId();
		 
	}
	@GetMapping("/perfilAdmin")
	public String adminProfile(Model model)  {

		model.addAttribute("Product", productServices.findAll());
		model.addAttribute("Users", userServices.findAll());

		return "adminProfile";
	}

	@PostMapping("/perfilAdmin/borrar/{id}")
	public String clearProduct(@PathVariable long id) {
		Optional<Product> product = productServices.findById(id);
		if (product.isPresent()) {

			products.delete(product.get());

			return "redirect:/";
		} else {
			return "searchnotfound";
		}
	}
	@PostMapping("/perfilAdmin/banear/{id}")
	public String banUser(@PathVariable long id) {
		Optional<User> users = userServices.findUserById(id);
		if(users.isPresent()) {

			userRepository.delete(users.get());
			return "redirect:/";
		} else {
			return "searchnotfound";
		}


	}

	@GetMapping("/perfil/{id}")
	public String profile(Model model, @PathVariable long id, HttpServletRequest request) {

		Principal principal = request.getUserPrincipal();


		Optional<User> Profile = userServices.findUserById(id);

		String original = principal.getName();
		String fake = Profile.get().getEmail();
		if(original.equals(fake)) {
			if (Profile.isPresent()) {

				model.addAttribute("Product", productServices.findAllProductsByPublisher(Profile.get(), PageRequest.of(0, 5)));
				model.addAttribute("TransactionsAsBuyer", transactionServices.findByBuyer(Profile.get(), PageRequest.of(0, 5)));
				model.addAttribute("TransactionsAsSeller", transactionServices.findBySeller(Profile.get(), PageRequest.of(0, 5)));
				model.addAttribute("Counteroffers", counterofferServices.findByReceiver(Profile.get(), PageRequest.of(0, 5)));
				model.addAttribute("name", Profile.get().getName());
				model.addAttribute("email", Profile.get().getEmail());
				model.addAttribute("address", Profile.get().getAddress());
				return "profile";
			} else {

				return "searchnotfound";
			}
		}else{
			return "searchnotfound";
		}
	}


	@PostMapping("/editado/{id}")
	public String editProduct(@PathVariable Long id, @RequestParam String title, @RequestParam String category, @RequestParam float price, @RequestParam String description) {


		Optional<Product> Products = productServices.findById(id);
		if (Products.isPresent()) {
			Product product = Products.get();
			product.setTitle(title);
			product.setCategory(category);
			product.setPrice(price);
			product.setDescription(description);
			//editar atributos del objeto
			productServices.save(product);
			return "redirect:/";
		} else {
			return "searchnotfound";
		}

	}
	
		 
	

}
