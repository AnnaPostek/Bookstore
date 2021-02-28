package pl.postek.final_shop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String id;
    @NotBlank(message = "Book need to have a title")
    @Size(min = 2, message = "Please add more than 2 sign")
    private String title;
    @NotNull (message = "Book need to have an author")
    @Size(min = 2, message = "Please add more that 2 sign")
    private String author;
    private String publishingHouse;
    @NotNull(message = "Category cannot be empty")
    private CategoryDto
            category;
    private String description;
    @NotNull(message = "Price cannot be empty")
    private BigDecimal price;
    private int quantity;


}
