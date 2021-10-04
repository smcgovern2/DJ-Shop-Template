package wctc.edu.djshoptemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import wctc.edu.djshoptemplate.entity.CartItem;
import wctc.edu.djshoptemplate.entity.Item;
import wctc.edu.djshoptemplate.repo.CartItemRepository;


import java.util.Optional;

public class BasicCartItemService implements CartItemService{
    CartItemRepository cartItemRepository;

    @Autowired
    public BasicCartItemService(CartItemRepository cir){
        this.cartItemRepository = cir;
    };
    @Override
    public Integer getItemCount(int itemID) {
        Optional<CartItem> ci = cartItemRepository.findById(itemID);
        if (ci.isPresent()) {
            return ci.get().getQuantity();
        }
        return null;

    }
}
