package es.codeurjc.Flyventas.repository;

import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {

    //@Query("SELECT p FROM Product p WHERE p.category = :category AND p.isSold=false")

    //public List<Product> findAll;
    
    @Query("SELECT p FROM Product p WHERE lower(p.title) LIKE %:title%")
    public List<Product> findByTitle(@Param("title") String title, Pageable page);

    @Query("SELECT p FROM Product p WHERE lower(p.category) LIKE %:category%")
    public List<Product> findProductByCategoryPageable(@Param("category") String category, Pageable page);

    @Query("SELECT p FROM Product p WHERE (p.user)=:user")
    public List<Product> findAllProductsByPublisher(@Param("user") User user, Pageable page);

    @Query("SELECT c FROM Counteroffer c WHERE (c.receiver)=:user")
    public List<Product> findAllCounteroffersByReceiver(@Param("user") User user, Pageable page);

    @Query("SELECT p FROM Product p WHERE p.id=:id")
    public Optional<Product> findById(@Param("id") Long id);
    
   /* @Query("SELECT p FROM Product p WHERE p.category LIKE %:category%")
    public Optional<Product> findProductByCategory(@Param("category") String category);

    Otra query para buscar por cada user cuando esté listo

    @Query("SELECT p FROM Product WHERE lo<p.price<high")
    public List<Product> findByPrice(int lo, int high);
    */
}
