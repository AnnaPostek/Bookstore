package pl.postek.final_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/welcome", "/home", "/index"})
    public String welcome(Model model) {
        return "index";
    }
}

