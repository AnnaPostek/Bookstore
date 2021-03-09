package pl.postek.final_shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.postek.final_shop.model.converter.CategoryConverter;
import pl.postek.final_shop.model.dto.BookDto;
import pl.postek.final_shop.model.dto.CategoryDto;
import pl.postek.final_shop.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final CategoryService service;
    private final CategoryConverter converter;

    public CategoryController(CategoryService service, CategoryConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/all-categories")
    public String getAllCategories(Model model) {
        List<CategoryDto> categoryDtos = service.findAllCategory()
                .stream()
                .map(converter::fromEntity)
                .collect(Collectors.toList());
        model.addAttribute("categories", categoryDtos);
       return "categories/all-categories";

    }
}
