package pl.postek.final_shop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.postek.final_shop.model.entity.Book;


import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private String id;
    private String categoryName;
    private List<Book> books;


}
