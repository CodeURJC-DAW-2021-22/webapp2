
package es.codeurjc.Flyventas.controller;



import es.codeurjc.Flyventas.model.User;

import es.codeurjc.Flyventas.repository.UserRepository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
	

	@Autowired
	private UserRepository Users;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
	
		 
	

}
