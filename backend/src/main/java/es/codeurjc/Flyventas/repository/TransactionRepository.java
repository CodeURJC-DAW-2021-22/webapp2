package es.codeurjc.Flyventas.repository;

import es.codeurjc.Flyventas.model.Transaction;
import es.codeurjc.Flyventas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    @Query("SELECT t from Transaction t")
    public List<Transaction> findAll();


    @Query("SELECT t FROM Transaction t WHERE t.id=:id")
    public Optional<Transaction> findById(@Param("id") Long id);

    public List<Transaction> findTransactionsByBuyer(User buyer, Pageable page);

    public List<Transaction> findTransactionsBySeller(User seller, Pageable page);

}
