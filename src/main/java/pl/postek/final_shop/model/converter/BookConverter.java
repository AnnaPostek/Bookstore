package pl.postek.final_shop.model.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.postek.final_shop.model.dto.BookDto;
import pl.postek.final_shop.model.entity.Book;
@Component
public class BookConverter implements Converter<Book, BookDto> {

    private CategoryConverter categoryConverter;

    @Autowired
    public void setCategoryConverter(CategoryConverter categoryConverter) {
        this.categoryConverter = categoryConverter;
    }

    @Override
    public BookDto fromEntity(Book entity) {
        return BookDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .publishingHouse(entity.getPublishingHouse())
                .category(categoryConverter.fromEntity(entity.getCategory()))
                .description(entity.getDescription())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .build();
    }

    @Override
    public Book fromDto(BookDto dto) {
        return Book.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .publishingHouse(dto.getPublishingHouse())
                .category(categoryConverter.fromDto(dto.getCategory()))
                .description(dto.getDescription())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();
    }
}
