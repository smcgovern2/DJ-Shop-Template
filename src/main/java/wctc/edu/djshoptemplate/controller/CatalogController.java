package wctc.edu.djshoptemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wctc.edu.djshoptemplate.service.ItemService;

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
        model.addAttribute("pageTitle", "Pick a Squirrel");
        model.addAttribute("itemList", itemService.getItemList());

        return "item-catalog";
    }
}
