package pl.postek.final_shop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String id;
    @NotNull
    @Size(min = 2)
    private String title;
    @NotNull
    @Size(min = 2)
    private String author;
    private String publishingHouse;
    @NotNull
    @Size(min = 2)
    private CategoryDto
            category;
    private String description;
    @NotNull
    @Min(1)
    private BigDecimal price;
    private int quantity;


}
