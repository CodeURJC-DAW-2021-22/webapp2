package es.codeurjc.Flyventas.controller;

import es.codeurjc.Flyventas.model.Counteroffer;
import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.Transaction;
import es.codeurjc.Flyventas.model.User;
import es.codeurjc.Flyventas.repository.CounterofferRepository;
import es.codeurjc.Flyventas.repository.TransactionRepository;
import es.codeurjc.Flyventas.services.CounterofferServices;
import es.codeurjc.Flyventas.services.ProductServices;
import es.codeurjc.Flyventas.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/counteroffers")
public class CounterofferRestController {

    @Autowired
    private ProductServices productServices;

    @Autowired
    private TransactionRepository transactions;

    @Autowired
    private CounterofferServices counterofferServices;

    @Autowired
    private UserServices userServices;

    @Autowired
    private CounterofferRepository counteroffers;

    @GetMapping("/addCounteroffer/{id}")
	public ResponseEntity addCounteroffer(@PathVariable long id) {

		Optional<Product> Product = productServices.findById(id);
		if (Product.isPresent()) {
            return new ResponseEntity<>(Product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addCounteroffer/{id}")
    @ResponseStatus(HttpStatus.CREATED)
	public Counteroffer createCounteroffer(HttpServletRequest request, @PathVariable long id, @RequestBody float newOffer) {

		Principal principal = request.getUserPrincipal();
		Optional<Product> Product = productServices.findById(id);
        Optional<User> User = userServices.findUserByEmail(principal.getName());

        Counteroffer counteroffer = new Counteroffer(Product.get(), newOffer, User.get());

        counteroffers.save(counteroffer);

        return counteroffer;
	}

    @GetMapping("/acceptCounteroffer/{id}")
    public ResponseEntity acceptCounteroffer(@PathVariable long id) {

        Optional<Counteroffer> counterOffer = counterofferServices.findById(id);
        if (counterOffer.isPresent()) {
            return new ResponseEntity<>(counterOffer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@PostMapping("/acceptCounteroffer/{id}")
    @ResponseStatus(HttpStatus.CREATED)
	public Transaction createTransaction(@PathVariable long id) {

	 	Optional<Counteroffer> counterOffer = counterofferServices.findById(id);
         Transaction transaction = new Transaction(counterOffer.get().getProduct(), counterOffer.get().getTransmitter(), counterOffer.get().getNewPrice());

        transactions.save(transaction);
        counteroffers.delete(counterOffer.get());

	 	return transaction;
	}
}
