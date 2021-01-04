package pl.postek.final_shop.model.dto;

import org.hibernate.validator.constraints.CreditCardNumber;
import pl.postek.final_shop.model.entity.Book;
import pl.postek.final_shop.model.entity.Customer;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private String orderId;
    private Customer customer;
    private List<Book> book = new ArrayList<>();
    private LocalDateTime date;
    @NotNull(message="Delivery name is required")
    private String deliveryName;
    @NotNull(message="Street is required")
    private String deliveryStreet;
    @NotNull(message="City is required")
    private String deliveryCity;
    @NotNull(message="Zip code is required")
    private String deliveryZip;
    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCv;
}
