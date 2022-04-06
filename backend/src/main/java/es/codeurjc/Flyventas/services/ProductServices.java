package es.codeurjc.Flyventas.services;



import java.util.Collection;
import java.util.List;
import java.util.Optional;

import es.codeurjc.Flyventas.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import es.codeurjc.Flyventas.repository.ProductRepository;
import es.codeurjc.Flyventas.model.Product;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository repository;

	public void save(Product product){
		repository.save(product);
	}
	
	public List<Product> findByTitle(String title, Pageable page) {
		return repository.findByTitle(title, page);
	}


	public List<Product> findProductByCategoryPageable(String category, Pageable page) {
		return repository.findProductByCategoryPageable(category, page);
	}

	public List<Product> findAllProductsByPublisher(User user, Pageable page) {
		return repository.findAllProductsByPublisher(user, page);
	}

	public List<Product> findAllCounteroffersByReceiver(User user, Pageable page) {
		return repository.findAllCounteroffersByReceiver(user, page);
	}

	public Collection<Product> findAll() {return repository.findAll();}
	
	public Optional<Product> findById(long id) {
		return repository.findById(id);
	}

	public void delete(long id) { repository.deleteById(id); }

	public boolean exist(long id) {	return repository.existsById(id); }

}
