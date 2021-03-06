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
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
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

	@PostMapping("/acceptCounteroffer")
    @ResponseStatus(HttpStatus.CREATED)
	public Transaction createTransaction(@RequestBody long id) {

	 	Optional<Counteroffer> counterOffer = counterofferServices.findById(id);
         Transaction transaction = new Transaction(counterOffer.get().getProduct(), counterOffer.get().getTransmitter(), counterOffer.get().getNewPrice());

        transactions.save(transaction);
        counteroffers.delete(counterOffer.get());

	 	return transaction;
	}

    @GetMapping("/")
    public ResponseEntity<Object> getCounterofferBySearch() {

        List<Counteroffer> counterOffer = counterofferServices.findAll();
        if (!counterOffer.isEmpty()) {
            return ResponseEntity.ok(counterOffer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public Counteroffer createCounteroffer(@RequestBody Counteroffer counteroffer) {

        counterofferServices.save(counteroffer);

        return counteroffer;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getCounterofferById(@PathVariable long id) {

        /*Optional<User> Profile = userServices.findUserById(id);
        List<Counteroffer> counterOffer = counterofferServices.findByReceiver(Profile.get(), PageRequest.of(0, 5));*/
        List<Counteroffer> counterOffer = counterofferServices.findCounteroffersByReceiverId(id);
        if (!counterOffer.isEmpty()) {
            return ResponseEntity.ok(counterOffer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }	
}
