package es.codeurjc.Flyventas.controller;

import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.repository.ProductRepository;
import es.codeurjc.Flyventas.services.Productservices;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import javax.annotation.PostConstruct;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository products;


    @PostConstruct
    public void init() {
        products.save(new Product( "Honda cbr 125", "Como nueva en Pantoja de la Sagra", "Motos", 1200, false));
        products.save(new Product("Camiseta firmada por Hamilton", "Tiene mucho valor sentimental", "Moda", 70, false));
        products.save(new Product("3 acciones de Santander", "Se las he robado a mi padre", "Otros", 25000, false));
        products.save(new Product("Promo en tiktok", "soy famoso", "Otros", 200, false));
        products.save(new Product("Riñon derecho", "urge venderlo para pagar la gasolina de mi bmw", "Otros", 350, false));
    }

    @PostMapping("/subirProducto")
    public String newProduct(@RequestParam String name, @RequestParam String description, @RequestParam String category, @RequestParam float price){
        products.save(new Product(name, description, category, price, false));

        return "perfil";
    }


    /* ejemplos con usuario
        products.save(new Product( "Honda cbr 125", "Como nueva en Pantoja de la Sagra", "Motos", 1200, "samuelrusu3"));
        products.save(new Product("Camiseta firmada por Hamilton", "Tiene mucho valor sentimental", "Moda", 70, "franciscardi"));
        products.save(new Product("3 acciones de Santander", "Se las he robado a mi padre", "Otros", 25000, "miguelruiiz"));
        products.save(new Product("Promo en tiktok", "soy famoso", "Otros", 200, "miguelruiiz"));
        products.save(new Product("Riñon derecho", "urge venderlo para pagar la gasolina de mi bmw", "Otros", 350, "jaiime00"));
    * */
    
 /*   
    @GetMapping("/busqueda/{category}")
	public String showBusqueda(Model model, @PathVariable String category) {

		Optional<Product> Product = Productservices.findByCategory(category);
		if (Product.isPresent()) {
			model.addAttribute("Product", Product.get());
			return "Product";
		} else {
			return "index";
		}

	}@GetMapping("/busquedanom/{title}")
	public String showBusquedanombre(Model model, @PathVariable String title) {

		Optional<Product> Product = Productservices.findByTitle(title);
		if (Product.isPresent()) {
			model.addAttribute("Product", Product.get());
			return "Product";
		} else {
			return "index";
		}

	}
    */
}
