package pl.postek.final_shop.model.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.postek.final_shop.model.dto.BookDto;
import pl.postek.final_shop.model.entity.Book;


@Component
public class BookConverter implements Converter<Book, BookDto> {

    private CategoryConverterToCategoryName categoryConverter;

    @Autowired
    public void setCategoryConverter(CategoryConverterToCategoryName categoryConverter) {
        this.categoryConverter = categoryConverter;
    }


    @Override
    public BookDto fromEntity(Book entity) {
        return BookDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .publishingHouse(entity.getPublishingHouse())
                .categoryId(entity.getCategory().getId())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .build();
    }

    @Override
    public Book fromDto(BookDto dto) {
        return new Book(
                dto.getId(),
                dto.getTitle(),
                dto.getAuthor(),
                dto.getPublishingHouse(),
                categoryConverter.convert(dto.getCategoryId()),
                dto.getDescription(),
                dto.getPrice(),
                dto.getQuantity()
        );
    }
}
