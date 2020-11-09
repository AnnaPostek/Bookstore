package pl.postek.final_shop.model.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.postek.final_shop.model.dto.BookDto;
import pl.postek.final_shop.model.dto.CategoryDto;
import pl.postek.final_shop.model.entity.Book;
import pl.postek.final_shop.model.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter implements Converter<Category, CategoryDto> {
    private BookConverter bookConverter;

    @Autowired
    public void setBookConverter(BookConverter bookConverter) {
        this.bookConverter = bookConverter;
    }

    @Override
    public CategoryDto fromEntity(Category entity) {
        return CategoryDto.builder()
                .id(entity.getId())
                .categoryName(entity.getCategoryName())
                .books(getAllBooksConverted(entity))
                .build();
    }

    private List<BookDto> getAllBooksConverted(Category entity) {
        return entity.getBooks()
                .stream()
                .map(bookConverter::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Category fromDto(CategoryDto dto) {
        return new Category(
                dto.getId(),
                dto.getCategoryName(),
                getAllItemsConvertedFrom(dto)
        );
    }

    private List<Book> getAllItemsConvertedFrom(CategoryDto dto) {
        return dto.getBooks()
                .stream()
                .map(bookConverter::fromDto)
                .collect(Collectors.toList());
    }

}
