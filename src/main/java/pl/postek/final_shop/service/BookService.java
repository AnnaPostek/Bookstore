package pl.postek.final_shop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.postek.final_shop.model.entity.Book;
import pl.postek.final_shop.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository repository;

    Logger logger = LoggerFactory.getLogger(BookService.class);

    public BookService(BookRepository repository) {
        this.repository = repository;
        logger.info("Book created");
    }

    public List<Book> findAllBooks() {
        List<Book> all = repository.findAll();
        return all;
    }

    public Optional<Book> findBookById(String id) {
        logger.info("find Book by Id [{}]", id);
        Optional<Book> byId = repository.findById(id);
        return byId;
    }

    public Book saveBook(Book book) {
        logger.info("Book save in progress {[]}", book);
        Book savedBook = repository.save(book);
        return savedBook;
    }

    public void delateById(Book book) {
        logger.info("Delete Book {[]}", book);
        repository.delete(book);
    }


}
