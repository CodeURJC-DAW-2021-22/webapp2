package es.codeurjc.Flyventas.repository;


import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.id=:id")
    public Optional<User> findUserById(@Param("id") long id);

    @Query("SELECT u FROM User u WHERE u.email=:email")
    Optional<User> findUserByEmail(@Param ("email") String email);

    Optional<User> findByName(@Param ("name") String name);

    /*
    @Query("SELECT p FROM User p WHERE p.title LIKE :apellido")
    public List<User> findByApellido(String apellido);
    
    @Query("SELECT p FROM User p WHERE p.id LIKE :id")
    public List<User> findByIdUser(long id);
    */
}