package pl.postek.final_shop.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.postek.final_shop.model.entity.Category;
import pl.postek.final_shop.repository.CategoryRepository;

import java.util.Optional;

@Component
public class CategoryConverterToCategoryName implements Converter<Long, Category> {

    private CategoryRepository repository;

    public CategoryConverterToCategoryName(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category convert(Long id) {
        Optional<Category> optionalCategory = repository.findById(id);
        return optionalCategory.isPresent() ? optionalCategory.get() : null;
    }
}
