package wctc.edu.djshoptemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import wctc.edu.djshoptemplate.entity.Cart;
import wctc.edu.djshoptemplate.entity.CartItem;
import wctc.edu.djshoptemplate.entity.Item;
import wctc.edu.djshoptemplate.service.ItemService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CatalogController {
    private ItemService itemService;
    @Autowired
    public CatalogController(ItemService is) {
        this.itemService = is;

    }
    @RequestMapping("/item")
    public String showItem(Model model,
                                      @RequestParam("id") int itemId) {
        model.addAttribute("pageTitle", itemService.getItem(itemId).getName());
        model.addAttribute("item", itemService.getItem(itemId));
        return "item";
    }

    @RequestMapping("/catalog")
    public String showCatalog(Model model){
        model.addAttribute("pageTitle", "Catalog");
        model.addAttribute("itemList", itemService.getItemList());

        return "item-catalog";
    }



    @PostMapping(value = "/checkout")
    public String checkout(Model model, @ModelAttribute("cart") Cart cart, BindingResult bindingResult){


        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            model.addAttribute("pageTitle", "Catalog");
            return "item-catalog";
        }
        System.out.println(cart);

        ArrayList<Item> purchasedItemList = new ArrayList<>();
        List<Integer> purchasedItemCount = new ArrayList<>();
        List<Double> purchasedItemSubtotal = new ArrayList<>();
        Double purchasedItemTotalPrice = 0.0;
        for (CartItem ci:cart.getCartItemList()) {
            Item item = itemService.getItem(ci.getItemID());
            if(item!=null) {
                item.setInventory(item.getInventory() - ci.getQuantity());
                itemService.saveItem(item);

                purchasedItemList.add(item);
                purchasedItemCount.add(ci.getQuantity());
                purchasedItemSubtotal.add(item.getPrice() * ci.getQuantity());
                purchasedItemTotalPrice += (item.getPrice() * ci.getQuantity());
            }
        }

        model.addAttribute("itemTotalPrice", purchasedItemTotalPrice);
        model.addAttribute("itemSubtotal", purchasedItemSubtotal);
        model.addAttribute("itemCount", purchasedItemCount);
        model.addAttribute("itemList", purchasedItemList);
        model.addAttribute("pageTitle", "Summary");

        System.out.println(model);
        return "/summary";
    }




}
