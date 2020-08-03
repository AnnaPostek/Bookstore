package pl.postek.final_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.postek.final_shop.model.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {



}
