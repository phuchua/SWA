package webshop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.data.ShoppingCartRepository;
import webshop.domain.Product;
import webshop.domain.ShoppingCart;

import java.util.Collection;

@Service
public class ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    public void addShoppingCart(ShoppingCart shoppingCart){
        shoppingCartRepository.insert(shoppingCart);
    }

    public ShoppingCart getShoppingCart(String shoppingCartNumber){
        return shoppingCartRepository.findByShoppingCartNumber(shoppingCartNumber);
    }
}
