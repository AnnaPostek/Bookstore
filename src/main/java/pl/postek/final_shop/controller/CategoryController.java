package pl.postek.final_shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.postek.final_shop.model.converter.CategoryConverterToCategoryName;

import pl.postek.final_shop.model.entity.Category;
import pl.postek.final_shop.service.CategoryService;


import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final CategoryService service;
    private final CategoryConverterToCategoryName converter;

    public CategoryController(CategoryService service, CategoryConverterToCategoryName converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/all-categories")
    public String getAllCategories(Model model) {
        List<Category> collect = service.getAllCategories()
                .stream()
                .map(category -> converter.convert(category.getId()))
                .collect(Collectors.toList());
        model.addAttribute("categories", collect);
       return "categories/all-categories";

    }
}
