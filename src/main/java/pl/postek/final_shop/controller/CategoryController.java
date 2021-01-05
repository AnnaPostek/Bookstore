package pl.postek.final_shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import pl.postek.final_shop.model.converter.CategoryConverter;

@Controller
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final CategoryConverter converter;
}
