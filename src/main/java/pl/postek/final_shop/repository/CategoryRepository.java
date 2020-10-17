package pl.postek.final_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.postek.final_shop.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
