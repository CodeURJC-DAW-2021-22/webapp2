package es.codeurjc.Flyventas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.Flyventas.model.User;
import es.codeurjc.Flyventas.repository.UserRepository;


@Service
public class Userservices {
	
	@Autowired
	private UserRepository repository;
	
	public void save(User user) {
		repository.save(user);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

}
