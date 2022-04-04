package es.codeurjc.Flyventas.controller;

import es.codeurjc.Flyventas.model.Product;
import es.codeurjc.Flyventas.services.ProductServices;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.Optional;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductServices productServices;

    // Productos por id

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {

        Product product = productServices.findById(id).orElseThrow();

        if(product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {

        productServices.save(product);

        return product;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) {

        try {
            productServices.delete(id);
            return new ResponseEntity<>(null, HttpStatus.OK);

        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product updatedProduct) throws SQLException {

        if (productServices.exist(id)) {

            if (updatedProduct.getImage()) {
                Product product = productServices.findById(id).orElseThrow();
                if (product.getImage()) {
                    updatedProduct.setImageFile(BlobProxy.generateProxy(product.getImageFile().getBinaryStream(),
                            product.getImageFile().length()));
                }
            }

            productServices.save(updatedProduct);

            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else	{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
            throws IOException {

        Optional<Product> product = productServices.findById(id);

        if(product.isPresent()){
            Product product1 = product.get();
            URI location = fromCurrentRequest().build().toUri();
            product1.setImage(true);
            product1.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));

            productServices.save(product1);
            return ResponseEntity.created(location).build();

        }else{
            return ResponseEntity.notFound().build();
        }




    }


    @GetMapping("/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException {

        Optional<Product> product = productServices.findById(id);
        if (product.isPresent() && product.get().getImageFile() != null) {

            Resource file = new InputStreamResource(product.get().getImageFile().getBinaryStream());
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg").contentLength(product.get().getImageFile().length()).body(file);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/image")
    public ResponseEntity<Object> editImage(@PathVariable long id, @RequestParam MultipartFile imageFile) throws IOException{

        Optional<Product> product = productServices.findById(id);
        if (product.isPresent()) {

            Product product1 = product.get();
            product1.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
            productServices.save(product1);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<?> getProductBySearch(@PathVariable String search) {

        List<Product> product = productServices.findByTitle(search, PageRequest.of(0,9));

        if(product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
