package pl.postek.final_shop.model.converter;

import pl.postek.final_shop.model.dto.BookDto;
import pl.postek.final_shop.model.entity.Book;

public class BookConverter implements Converter<Book, BookDto> {

    @Override
    public Book fromEntity(BookDto entity) {
        return Book.builder()
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .publishingHouse(entity.getPublishingHouse())
                .category(entity.getCategory())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .build();
    }

    @Override
    public BookDto fromDto(Book dto) {
        return BookDto.builder().
                title(dto.getTitle())
                .author(dto.getAuthor())
                .publishingHouse(dto.getPublishingHouse())
                .category(dto.getCategory())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();
    }
}
