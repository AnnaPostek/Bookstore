package pl.postek.final_shop.model.converter;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.postek.final_shop.model.dto.BookDto;
import pl.postek.final_shop.model.entity.Book;
import pl.postek.final_shop.model.entity.Category;

import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookConverterTest {

    @Autowired
    BookConverter converter;

    @Test
    void convertBookForBookDto_returnTrue() {
        //given
        Category cat = new Category(1L, "horror");
        Book book = new Book("1", "title", "author", "sowa", cat, "desc", new BigDecimal(15.55), 15);
        //when
        BookDto bookDto = converter.fromEntity(book);
        //then
        assertEquals(book.getAuthor(), bookDto.getAuthor());

    }

    @Test
    void convertBookDtoForBook_returnTrue() {

        //given
        Long categoryId = 2L;
        BookDto dto = new BookDto("1", "title", "author", "sowa", categoryId, "desc", new BigDecimal(15.55), 15);
        //when
        Book book = converter.fromDto(dto);
        //then
        assertEquals(book.getPublishingHouse(), dto.getPublishingHouse());
    }
}