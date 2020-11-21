package pl.postek.final_shop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.postek.final_shop.model.entity.Book;
import pl.postek.final_shop.model.entity.Category;
import pl.postek.final_shop.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    public static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private BookRepository repository;


    public BookService(BookRepository repository) {
        this.repository = repository;
        logger.info("BookService created");
    }

    public List<Book> findAllBooks() {
        List<Book> all = repository.findAll();
        logger.info("number of found items: [{}]", all.size());
        return all;
    }

    public Optional<Book> findBookById(String id) {
        logger.info("find Book by Id [{}]", id);
        Optional<Book> byId = repository.findById(id);
        return byId;
    }

    @Transactional
    public Book saveBook(Book book) {
        logger.info("Book save in progress {[]}", book);
        Book savedBook = repository.save(book);
        logger.info("after saving: [{}]", savedBook);
        return savedBook;
    }

    public void delateBookById(String id) {
        logger.info("Delete Book with id {[]}", id);
        repository.deleteById(id);
    }


}
