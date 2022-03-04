package es.codeurjc.Flyventas.repository;

import es.codeurjc.Flyventas.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT p FROM Transaction p WHERE p.id LIKE %:id%")
    public Optional<Transaction> findById(@Param("id") Long id);




}
