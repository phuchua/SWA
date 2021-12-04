package webshop.data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import webshop.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer>{
    @Override
    <E extends Product> E insert(E entity);

    Product findByProductNumber(String productNumber);

    List<Product> findAll();
}
