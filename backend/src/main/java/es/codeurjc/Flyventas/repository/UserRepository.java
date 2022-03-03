package es.codeurjc.Flyventas.repository;


import es.codeurjc.Flyventas.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    /*
    @Query("SELECT p FROM User p WHERE p.title LIKE :apellido")
    public List<User> findByApellido(String apellido);
    
    @Query("SELECT p FROM User p WHERE p.id LIKE :id")
    public List<User> findByIdUser(long id);
    */
}