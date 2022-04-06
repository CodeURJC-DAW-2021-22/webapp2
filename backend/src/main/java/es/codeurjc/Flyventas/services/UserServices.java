package es.codeurjc.Flyventas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import es.codeurjc.Flyventas.model.User;
import es.codeurjc.Flyventas.repository.UserRepository;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class UserServices {

    @Autowired
	private UserRepository repository;

	public Optional<User> findUserById(long id) {
		return repository.findUserById(id);
	}

	public Optional<User> findUserByEmail(String email) {
		return repository.findUserByEmail(email);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public void save(User user) {
		repository.save(user);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

	public boolean exist(long id) {
		return repository.existsById(id);
	}
}
