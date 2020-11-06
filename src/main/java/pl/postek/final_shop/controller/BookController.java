package pl.postek.final_shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.postek.final_shop.exception.BookNotFoundException;
import pl.postek.final_shop.model.converter.BookConverter;
import pl.postek.final_shop.model.dto.BookDto;
import pl.postek.final_shop.model.entity.Book;
import pl.postek.final_shop.service.BookService;

import java.util.Optional;

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
        BookDto bookDto = service.findBookById(id)
                .map(converter::fromEntity)
                .orElse(BookDto.builder().build());
        model.addAttribute("bookToShow", bookDto);
        return "books/show-book";
    }

    @GetMapping("/add-book")
    public String addBook(Model model) {
        logger.info("add Book()");
        model.addAttribute("book", BookDto.builder().build());
        model.addAttribute("current_operation", "Adding new book");
        return "books/add-edit";
    }

    @PostMapping("/edit-book/{id}")
    public String editBook(Model model, @PathVariable String id) {
        logger.info("editBook() with id: [{}]", id);
        Optional<Book> foundBook = service.findBookById(id);

        BookDto bookDto = foundBook
                .map(converter::fromEntity)
                .orElseThrow(() -> new BookNotFoundException(String.format("Book with id %s not exists", id)));
        model.addAttribute("book", bookDto);
        model.addAttribute("current_operation", "Editing book with id: " + id);
        return "books/add-edit";
    }

    @ExceptionHandler(BookNotFoundException.class)
    public String errorPage(BookNotFoundException exc, Model model) {
        logger.warn("something is wrong...", exc);
        model.addAttribute("exc_message", exc.getMessage());
        return "exception/error-item-not-found";
    }


}
