package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.domain.Product;
import webshop.domain.ShoppingCart;
import webshop.service.ProductService;
import webshop.service.ShoppingCartService;

import java.util.Collection;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/shopping")
    public ResponseEntity<?> addToShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartService.addShoppingCart(shoppingCart);
        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }

    @GetMapping("/shopping/{shoppingCartNumber}")
    public ResponseEntity<?>getShoppingCart(@PathVariable String shoppingCartNumber){
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(shoppingCartNumber);
        if(shoppingCart == null)
            return new ResponseEntity<>("Shopping Cart Number " + shoppingCartNumber + " not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }
}