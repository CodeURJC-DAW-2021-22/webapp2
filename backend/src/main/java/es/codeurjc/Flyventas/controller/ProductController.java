package es.codeurjc.Flyventas.controller;

import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/posts")
public class ProductController {

    @Autowired
    private ProductRepository products;

    @PostConstruct
    public void init() {
        products.save(new Product(6, "Honda cbr 125", "Como nueva en Pantoja de la Sagra", "Motos", 1200, "samuelrusu3"));
        /*products.save(new Product(2, "Camiseta firmada por Hamilton", "Tiene mucho valor sentimental", "Moda", 70, "franciscardi"));
        products.save(new Product(3, "3 acciones de Santander", "Se las he robado a mi padre", "Otros", 25000, "miguelruiiz"));
        products.save(new Product(4, "Promo en tiktok", "soy famoso", "Otros", 200, "miguelruiiz"));
        products.save(new Product(5, "Riñon derecho", "urge venderlo para pagar la gasolina de mi bmw", "Otros", 350, "jaiime00"));*/

        //Funcionan pero el ID es siempre 0 y como tiene que ser una unique key no funciona. Por que es 0???
    }
}
