
package es.codeurjc.Flyventas.controller;



import es.codeurjc.Flyventas.model.User;

import es.codeurjc.Flyventas.repository.UserRepository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfiles")
public class UserController {
	

	@Autowired
	private UserRepository Users;
	
	@PostConstruct
    public void init() {
		Users.save(new User("nombre", "apellido" , "email", "address", "encodedPassword", true, "categoria1", "categoria2", "categoria3"));
	}
	@PostMapping("/perfil")
	public  String newuser(@RequestBody String nombre, @RequestBody String apellido, @RequestBody String email, @RequestBody String address, @RequestBody String encodedPassword, @RequestBody boolean admin, @RequestBody String categoria1, @RequestBody String categoria2, @RequestBody String categoria3) {
		Users.save(new User(nombre, apellido, email, address, encodedPassword, false, categoria1, categoria2, categoria3));
		
		return "perfil";
		 
	}
	
		 
	

}
