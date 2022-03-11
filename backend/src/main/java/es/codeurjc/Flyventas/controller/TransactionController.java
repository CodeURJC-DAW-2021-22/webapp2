package es.codeurjc.Flyventas.controller;

import es.codeurjc.Flyventas.model.Counteroffer;
import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.model.Transaction;

import es.codeurjc.Flyventas.repository.CounterofferRepository;
import es.codeurjc.Flyventas.repository.ProductRepository;
import es.codeurjc.Flyventas.repository.TransactionRepository;
import es.codeurjc.Flyventas.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.codeurjc.Flyventas.services.ProductServices;
import es.codeurjc.Flyventas.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TransactionServices transactionsservice;


    //Transaction Controller

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

    @GetMapping("/resumen/{id}/{tokenpayment}")
    public String newTransaction(Model model, @PathVariable long id, @PathVariable String tokenpayment) {

        Optional<Product> Product = productServices.findById(id);
        //Before making the transaction, it would be necessary to check if the token that you have sent us through the link is the same as the one that the payment gateway sends us.
        if (Product.isPresent()) {
            transactions.save(new Transaction(Product.get(), null));

            model.addAttribute("Product", Product.get());

            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo("carlos.hdezhdez01@gmail.com");
            email.setSubject("Recibo FlyVentas");
            String str = Long.toString(id);
            String message = ("http://localhost:8080/resumen/"+str+"/12345/?format=pdf");
            email.setText(message);
            mailSender.send(email);

            return "resumen";
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

    @PostMapping("/counteroffer/{id}")
    public String contraoffer(@PathVariable long id, @RequestParam float newOffer) {

        Optional<Product> Product = productServices.findById(id);
        if (Product.isPresent()) {

            counteroffers.save(new Counteroffer(Product.get(), newOffer, null));

            return "redirect:/";
        } else {
            return "searchnotfound";
        }
    }

}
