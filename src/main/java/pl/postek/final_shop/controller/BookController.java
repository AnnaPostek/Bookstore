package pl.postek.final_shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.postek.final_shop.exception.BookNotFoundException;
import pl.postek.final_shop.model.converter.BookConverter;
import pl.postek.final_shop.model.dto.BookDto;
import pl.postek.final_shop.model.dto.CategoryDto;
import pl.postek.final_shop.model.entity.Book;
import pl.postek.final_shop.service.BookService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookService service;
    private final BookConverter converter;

    public BookController(final BookService service, final BookConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/all-books")
    public String getAllBooks(Model model) {
        logger.info("getAllBooks()");
        List<BookDto> bookDtos = service.findAllBooks()
                .stream()
                .map(converter::fromEntity)
                .collect(Collectors.toList());
        model.addAttribute("books", bookDtos);
        return "books/all-books";

    }

    @GetMapping("/books/{id}")
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
        model.addAttribute("book", BookDto.builder().category(CategoryDto.builder().build()).build());
        model.addAttribute("current_operation", "Adding new book");
        return "books/add-edit";
    }

    @PostMapping("/book-save")
    public String saveBook(@Valid BookDto book, BindingResult bindingResult, Model model) {
        logger.info("saveBook() [{}]", book);
        if (bindingResult.hasErrors()) {
            model.addAttribute("book", book);
            logger.warn("book is not valid");
            return "books/add-edit";
        }
        Book convertedBook = converter.fromDto(book);
        Book saved = service.saveBook(convertedBook);
        logger.info("saveBook() [{}]", saved);
        return "redirect:/books/" + saved.getId();

    }

    @GetMapping("/edit-book/{id}")
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
