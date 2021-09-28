package wctc.edu.djshoptemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wctc.edu.djshoptemplate.entity.Item;
import wctc.edu.djshoptemplate.repo.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasicItemService implements ItemService {
    private ItemRepository itemRepository;


    @Autowired
    public BasicItemService(ItemRepository ir){this.itemRepository = ir;}
    @Override
    public Item getItem(int itemId) {
        Optional<Item> i = itemRepository.findById(itemId);
        if (i.isPresent()) {
            return i.get();
        }
        return null;
    }

    @Override
    public List<Item> getItemList() {
        List<Item> list = new ArrayList<>();
        itemRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void deleteItem(int itemID) {
        Optional<Item> s = itemRepository.findById(itemID);
        if (s.isPresent()) {
            itemRepository.deleteById(itemID);
        }
    }

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }
}
