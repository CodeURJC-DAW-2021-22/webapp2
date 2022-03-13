package es.codeurjc.Flyventas.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.codeurjc.Flyventas.repository.ProductRepository;
import es.codeurjc.Flyventas.model.Product;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findByTitle(String title, Pageable page) {
		return repository.findByTitle(title, page);
	}

	public List<Product> findProductByCategoryPageable(String category, Pageable page) {
		return repository.findProductByCategoryPageable(category, page);
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
