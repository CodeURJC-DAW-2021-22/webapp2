package es.codeurjc.Flyventas.repository;


import es.codeurjc.Flyventas.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
	/*
	@Query("SELECT p FROM User p WHERE p.category = :nombre")
    public List<User> findByNombre(String nombre);
    
    @Query("SELECT p FROM User p WHERE p.title LIKE :apellido")
    public List<User> findByApellido(String apellido);
    
    @Query("SELECT p FROM User p WHERE p.id LIKE :id")
    public List<User> findByIdUser(long id);
    */
}