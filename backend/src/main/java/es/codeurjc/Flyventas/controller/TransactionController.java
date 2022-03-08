package es.codeurjc.Flyventas.controller;

import es.codeurjc.Flyventas.model.Counteroffer;
import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.Transaction;

import es.codeurjc.Flyventas.repository.CounterofferRepository;
import es.codeurjc.Flyventas.repository.ProductRepository;
import es.codeurjc.Flyventas.repository.TransactionRepository;
import es.codeurjc.Flyventas.repository.UserRepository;

import javax.annotation.PostConstruct;

import es.codeurjc.Flyventas.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TransactionController {


    @Autowired
    private ProductServices productServices;

    @Autowired
    private CounterofferRepository counteroffers;

    @Autowired
    private TransactionRepository transactions;

    //Transaction Controller

    @PostConstruct
    public void init() {

        transactions.save(new Transaction(productServices.findById(2).get()));
    }


    @GetMapping("/confirmacionCompra/{id}")
    public String confirmTransaction(Model model, @PathVariable long id) {

        Optional<Product> Product = productServices.findById(id);
        if (Product.isPresent()) {
            model.addAttribute("Product", Product.get());
            return "compra";
        } else {
            return "searchnotfound";
        }
    }

    @GetMapping("/compra/{id}/{tokenpayment}")
    public String newTransaction(@PathVariable long id, @PathVariable String tokenpayment) {

        Optional<Product> Product = productServices.findById(id);
        //Before making the transaction, it would be necessary to check if the token that you have sent us through the link is the same as the one that the payment gateway sends us.
        if (Product.isPresent()) {
            transactions.save(new Transaction(Product.get()));
            return "/";
        } else {

            return "searchnotfound";
        }
    }

    //Counteroffer Controller

    @GetMapping("/confirmacionContraoferta/{id}")
    public String confirmCounteroffer(Model model, @PathVariable long id) {

        Optional<Product> Product = productServices.findById(id);
        if (Product.isPresent()) {
            model.addAttribute("Product", Product.get());
            return "contraoferta";
        } else {
            return "searchnotfound";
        }
    }

    @PostMapping("/counteroffer")
    public String contraoffer(@PathVariable long id, @RequestParam float newOffer) {

        Optional<Product> Product = productServices.findById(id);
        if (Product.isPresent()) {

            counteroffers.save(new Counteroffer(Product.get(), newOffer));

            return "index";
        } else {
            return "searchnotfound";
        }
    }
}
