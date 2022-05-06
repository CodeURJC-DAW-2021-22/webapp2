package es.codeurjc.Flyventas.controller;

import es.codeurjc.Flyventas.model.Counteroffer;
import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.Transaction;
import es.codeurjc.Flyventas.model.User;
import es.codeurjc.Flyventas.repository.CounterofferRepository;
import es.codeurjc.Flyventas.repository.TransactionRepository;
import es.codeurjc.Flyventas.services.CounterofferServices;
import es.codeurjc.Flyventas.services.ProductServices;
import es.codeurjc.Flyventas.services.TransactionServices;
import es.codeurjc.Flyventas.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionRestController {

    @Autowired
    private ProductServices productServices;

    @Autowired
    private TransactionRepository transactions;

    @Autowired
    private TransactionServices transactionServices;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserServices userServices;


    @GetMapping("/{id}")
	public ResponseEntity comfirmTransaction(@PathVariable long id) {

		Optional<Transaction> transaction = transactionServices.findById(id);
		if (transaction.isPresent()) {
            return new ResponseEntity<>(transaction, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity newTransaction(HttpServletRequest request, @RequestBody Product product) {

        Principal principal = request.getUserPrincipal();

        //Before making the transaction, it would be necessary to check if the token that you have sent us through the link is the same as the one that the payment gateway sends us.
        SimpleMailMessage email = null;

            Optional<User> User = userServices.findUserByEmail(principal.getName());
            transactions.save(new Transaction(product, User.get(), product.getPrice()));

            email = new SimpleMailMessage();
            email.setTo(principal.getName());
            email.setSubject("Recibo FlyVentas");
            String str = Long.toString(product.getId());
            String message = ("https://localhost:8443/confirmacionCompra/" + str + "/?format=pdf");
            email.setText(message);
            mailSender.send(email);
            return new ResponseEntity<>(email, HttpStatus.OK);
        }

    @GetMapping("/")
    public ResponseEntity<Object> getTransactionBySearch() {

        List<Transaction> transactions = transactionServices.findAll();
        if (!transactions.isEmpty()) {
            return ResponseEntity.ok(transactions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
    @GetMapping("/userBuyer/{id}")
    public ResponseEntity<Object> getTransactionUserBuyer(@PathVariable long id){
        Optional<User> Users = userServices.findUserById(id);
        List<Transaction> transactionsBuyer = transactionServices.findByBuyer(Users.get(), PageRequest.of(0, 5));
        if(transactionsBuyer != null){
            return ResponseEntity.ok(transactionsBuyer);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/userSeller/{id}")
    public ResponseEntity<List<Transaction>> getTransactionUserSeller(@PathVariable long id){
        Optional<User> Users = userServices.findUserById(id);
        List<Transaction> transactionsSeller = transactionServices.findBySeller(Users.get(),PageRequest.of(0, 5));
        if(transactionsSeller != null){
            return ResponseEntity.ok(transactionsSeller);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
	


    }
