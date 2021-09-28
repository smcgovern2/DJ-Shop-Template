package wctc.edu.djshoptemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {


        @RequestMapping("/")
        public String showHomePage(Model model) {
            model.addAttribute("pageTitle", "Item Store");
            return "index";
        }
    }

