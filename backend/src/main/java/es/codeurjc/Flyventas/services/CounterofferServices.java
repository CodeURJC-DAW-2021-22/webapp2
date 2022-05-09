package es.codeurjc.Flyventas.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import es.codeurjc.Flyventas.model.Counteroffer;
import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.User;
import es.codeurjc.Flyventas.repository.CounterofferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CounterofferServices {

    public Collection<Counteroffer> findAll;

    @Autowired
    private CounterofferRepository repository;

    public Optional<Counteroffer> findById(long id) {
        return repository.findById(id);
    }

    public List<Counteroffer> findByReceiver(User receiver, Pageable pageable) {

        return repository.findCounteroffersByReceiver(receiver, pageable);
    }
    public List<Counteroffer> findCounteroffersByReceiverId(long id) {
        return repository.findCounteroffersByReceiverId(id);
    }

    public void save(Counteroffer counteroffer){
        repository.save(counteroffer);
    }

    public List<Product> findHottestProducts(Pageable page) {
        return repository.findHottestProducts(page);
    }

    public List<Counteroffer> findAll() {
        return repository.findAll();
    }
}

