package es.codeurjc.Flyventas.services;



import java.util.Collection;
import java.util.Optional;

import es.codeurjc.Flyventas.model.User;
import es.codeurjc.Flyventas.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.codeurjc.Flyventas.repository.ProductRepository;
import es.codeurjc.Flyventas.model.Product;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository repository;

	public Page<Product> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Collection<Product> findAll() {
		return repository.findAll();
	}

	public void save(Product post) {

		repository.save(post);
	}

	public void deleteById(long id) {
		this.repository.deleteById(id);
	}
	
	public Optional<Product> findByCategory(String category) {
		return repository.findProductByCategory(category);
	}
	
	public Optional<Product> findByTitle(String title) {
		return repository.findByTitle(title);
	}
	
	public Optional<Product> findById(long id) {
		return repository.findById(id);
	}
/*
	public boolean exist(long id) {
		return repository.existsById(id);
	}
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public void save(Product Product) {
		repository.save(Product);
	}
	

	public void delete(long id) {
		repository.deleteById(id);
	}

*/
}
