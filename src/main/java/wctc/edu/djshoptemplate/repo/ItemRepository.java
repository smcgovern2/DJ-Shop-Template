package wctc.edu.djshoptemplate.repo;

import org.springframework.data.repository.CrudRepository;
import wctc.edu.djshoptemplate.entity.Item;

import java.util.List;



public interface ItemRepository extends CrudRepository<Item, Integer> {

}

