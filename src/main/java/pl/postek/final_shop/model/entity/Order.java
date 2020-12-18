package pl.postek.final_shop.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId;
    @ManyToOne
    private Customer customer;
    @ManyToMany
    private List<Book> book = new ArrayList<>();
    private LocalDateTime date;
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCv;

    public void addBook(Book book) {
        this.book.add(book);
    }

    @PrePersist
    void placeAt() {
        this.date = LocalDateTime.now();
    }

}
