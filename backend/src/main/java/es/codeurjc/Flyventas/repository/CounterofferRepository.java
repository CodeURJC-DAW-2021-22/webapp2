package es.codeurjc.Flyventas.repository;

import es.codeurjc.Flyventas.model.Counteroffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CounterofferRepository extends JpaRepository<Counteroffer, Long> {

    @Query("SELECT p FROM Counteroffer p WHERE p.id LIKE %:id%")
    public Optional<Counteroffer> findById(@Param("id") Long id);


}