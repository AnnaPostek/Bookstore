package pl.postek.final_shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.postek.final_shop.model.converter.BookConverter;
import pl.postek.final_shop.model.dto.BookDto;
import pl.postek.final_shop.service.BookService;

@Controller
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookService service;
    private final BookConverter converter;

    public BookController(final BookService service, final BookConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/book/{id}")
    public String displayBookById(@PathVariable String id, Model model) {
        logger.info("Show Book With id [{}]", id);
        BookDto bookDto = service.findBookById(id).map(converter::fromEntity).orElse(BookDto.builder().build());
        model.addAttribute("bookToShow", bookDto);
        return "books/show-book";
    }
}
