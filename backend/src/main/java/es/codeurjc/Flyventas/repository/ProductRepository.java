package es.codeurjc.Flyventas.repository;

import es.codeurjc.Flyventas.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    public List<Product> findByCategory(String category);
    
    @Query("SELECT p FROM Product p WHERE p.title LIKE :title")
    public List<Product> findByTitle(String title);
    
    @Query("SELECT p FROM Product p WHERE p.id LIKE :id")
    public List<Product> findById(long id);

    //Otra query para buscar por cada user cuando esté listo
/*
    @Query("SELECT p FROM Product WHERE lo<p.price<high")
    public List<Product> findByPrice(int lo, int high);
    */
}
