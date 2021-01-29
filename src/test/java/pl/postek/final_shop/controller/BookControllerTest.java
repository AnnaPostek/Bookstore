package pl.postek.final_shop.controller;

import org.junit.jupiter.api.Test;
import pl.postek.final_shop.model.dto.BookDto;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

class BookControllerTest {

    @Test
    public void whenRequestGet_thenOK() {
        when().request("GET", "/all-books").then().statusCode(200);
        when().request("GET", "/add-book").then().statusCode(200);
    }

    @Test
    public void whenRequestGet_withParameter_thenOK() {
        String id = "1";
        when().request("GET", "/books/{id}", id).then().statusCode(200);
        when().request("GET", "/edit-book/{id}", id).then().statusCode(200);
    }

    @Test
    public void whenRequestPost_thenOK() {
        with().body(new BookDto())
                .when()
                .request("POST", "/book-save")
                .then()
                .statusCode(200);
    }


}