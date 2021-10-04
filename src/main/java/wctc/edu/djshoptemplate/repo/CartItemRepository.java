package wctc.edu.djshoptemplate.repo;

import org.springframework.data.repository.CrudRepository;
import wctc.edu.djshoptemplate.entity.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem,Integer> {


}
