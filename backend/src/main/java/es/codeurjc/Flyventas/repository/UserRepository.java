package es.codeurjc.Flyventas.repository;

import es.codeurjc.Flyventas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}