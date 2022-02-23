package es.codeurjc.Flyventas.repository;

import es.codeurjc.Flyventas.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
