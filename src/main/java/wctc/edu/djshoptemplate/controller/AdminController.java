package wctc.edu.djshoptemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wctc.edu.djshoptemplate.entity.Item;
import wctc.edu.djshoptemplate.service.ItemService;

import javax.validation.Valid;

@Controller
public class AdminController {
    ItemService itemService;
        @Autowired
    public AdminController(ItemService is) {
        this.itemService = is;
    }

    @RequestMapping("/admin")
    public String showCatalog(Model model){
        model.addAttribute("pageTitle", "Admin Page");
        model.addAttribute("itemList", itemService.getItemList());

        return "admin";
    }

    @RequestMapping("/delete")
    public String deleteItem(Model model, @RequestParam("id") int ItemID) {
        itemService.deleteItem(ItemID);

        return "forward:/admin";
        }

    @RequestMapping("/add-item")
    public String showItemForm(Model model) {
        model.addAttribute("pageTitle", "addItem");


        Item item = new Item();
        model.addAttribute("item", item);

        return "add-item";
    }

    @PostMapping("/save")
    public String processItem(Model model, @Valid @ModelAttribute Item item, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            model.addAttribute("pageTitle", "Add Item");
            return "index";
        }
                  

        itemService.saveItem(item);

        model.addAttribute("pageTitle", "Thank You!");


        return "forward:/admin";
    }

    @RequestMapping("/update")
    public String showItem(Model model,
                           @RequestParam("id") int itemId) {
        model.addAttribute("pageTitle", "Update " + itemService.getItem(itemId).getName());
        model.addAttribute("item", itemService.getItem(itemId));
        return "update";
    }
}
