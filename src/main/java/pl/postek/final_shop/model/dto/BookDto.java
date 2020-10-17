package pl.postek.final_shop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.postek.final_shop.model.entity.Category;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String id;
    private String title;
    private String author;
    private String publishingHouse;
    private CategoryDto category;
    private String description;
    private BigDecimal price;
    private int quantity;


}
