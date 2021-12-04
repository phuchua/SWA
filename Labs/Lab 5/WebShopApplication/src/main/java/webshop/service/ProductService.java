package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.data.ProductRepository;
import webshop.domain.Product;

import java.util.Collection;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void addProduct(Product product){
        productRepository.insert(product);
    }
    public Product getProduct(String productNumber){
        return productRepository.findByProductNumber(productNumber);
    }
    public Collection<Product> getAllProduct(){
        return productRepository.findAll();
    }

}
