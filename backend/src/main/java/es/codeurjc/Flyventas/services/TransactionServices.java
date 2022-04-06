package es.codeurjc.Flyventas.services;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import es.codeurjc.Flyventas.model.Transaction;
import es.codeurjc.Flyventas.model.User;
import es.codeurjc.Flyventas.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServices {

    public Collection<Transaction> findAll;

    @Autowired
    private TransactionRepository repository;

    public Optional<Transaction> findById(long id) {

        return repository.findById(id);
    }

    public List<Transaction> findByBuyer(User buyer, Pageable pageable) {

        return repository.findTransactionsByBuyer(buyer, pageable);
    }

    public List<Transaction> findBySeller(User seller, Pageable pageable) {

        return repository.findTransactionsBySeller(seller, pageable);
    }


}
