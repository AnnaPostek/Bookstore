package pl.postek.final_shop.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private Long id;
    private String categoryName;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Book> books;


    public Category(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
        this.books = new ArrayList<>();
    }
}
