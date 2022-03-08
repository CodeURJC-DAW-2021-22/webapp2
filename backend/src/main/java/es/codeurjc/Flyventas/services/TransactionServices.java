package es.codeurjc.Flyventas.services;

import java.util.Optional;


import es.codeurjc.Flyventas.model.Transaction;
import es.codeurjc.Flyventas.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServices {

    @Autowired
    private TransactionRepository repository;

    public Optional<Transaction> findById(long id) {
        return repository.findById(id);
    }


}
