package es.codeurjc.Flyventas.controller;

import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.Transaction;

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
    private ProductRepository products;
    @Autowired
    private ProductServices productServices;


    @Autowired
    private TransactionRepository transactions;
    @Autowired
    private ProductServices transactionServices;


    @PostConstruct
    public void init() {

        transactions.save(new Transaction("la moto de mi tia paca", 120));
    }


    @GetMapping("/confirmacionCompra/{id}")
    public String comfirmTransaction(Model model, @PathVariable long id) {

        Optional<Product> Product = productServices.findById(id);
        if (Product.isPresent()) {
            model.addAttribute("Product", Product.get());
            return "compra";
        } else {
            return "searchnotfound";
        }
    }

    @PostMapping("/compra/{id}/{title}/{price}")
    public String newTransaction(@PathVariable long id, @PathVariable String title, @PathVariable float price) {

        Optional<Product> Product = productServices.findById(id);
        if (Product.isPresent()) {

            transactions.save(new Transaction(title, price));
            //transactions.save(new Transaction(Product.get().getTitle(), Product.get().getPrice()));
            return "index";
        } else {

            return "searchnotfound";
        }
    }

}
