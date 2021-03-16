package pl.postek.final_shop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.postek.final_shop.model.entity.Category;
import pl.postek.final_shop.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    public static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

   public List<Category> getAllCategories(){
       List<Category> all = repository.findAll();
       logger.info("number of found category: " + all.size());
       return all;
   }
}
