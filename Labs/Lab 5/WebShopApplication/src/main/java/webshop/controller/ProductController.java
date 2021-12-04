package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import webshop.domain.Product;
import webshop.service.ProductService;

import java.util.Collection;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/product/{productNumber}")
    public ResponseEntity<?>getProduct(@PathVariable String productNumber){
        Product product = productService.getProduct(productNumber);
        if(product == null)
            return new ResponseEntity<>("Product " + productNumber + " not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        Collection<Product> allProducts = productService.getAllProduct();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
}
