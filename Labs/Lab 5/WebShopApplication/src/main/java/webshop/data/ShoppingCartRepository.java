package webshop.data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import webshop.domain.ShoppingCart;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, Integer>{
    @Override
    <E extends ShoppingCart> E insert(E entity);

    ShoppingCart findByShoppingCartNumber(String shoppingCartNumber);

    List<ShoppingCart> findAll();
}
