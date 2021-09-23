package wctc.edu.djshoptemplate.service;

import wctc.edu.djshoptemplate.entity.Item;

import java.util.List;

public interface ItemService {
    Item getItem(int itemID);

    List<Item> getItemList();
}
