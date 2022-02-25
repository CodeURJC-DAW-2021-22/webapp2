package es.codeurjc.Flyventas.controller;

import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class ProductController {

    @Autowired
    private ProductRepository products;

    @PostConstruct
    public void init() {
        products.save(new Product());
        //como le meto un producto con cosas de ejemplo?
        //products.save(new Product("Juan", "Compro coche", "Pago bien"));
    }
}
