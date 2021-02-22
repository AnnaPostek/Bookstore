package pl.postek.final_shop.controller;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import pl.postek.final_shop.model.dto.BookDto;
import pl.postek.final_shop.model.dto.CategoryDto;
import pl.postek.final_shop.model.entity.Category;

import java.math.BigDecimal;

import static io.restassured.RestAssured.*;


class BookControllerTest {

    @Test
    public void whenRequestGet_adminRole_thenOK() {
        given().auth().basic("admin", "admin")
                .when().request("GET", "/all-books").then().statusCode(200);
        given().auth().basic("admin", "admin").when().request("GET", "/add-book").then().statusCode(200);
    }

    @Test
    public void whenRequestGet_userRole_thenOK() {
        given().auth().basic("user", "user")
                .when().request("GET", "/all-books").then().statusCode(200);
        given().auth().basic("user", "user").when().request("GET", "/add-book").then().statusCode(200);
    }


    @Test
    public void whenRequestGet_withParameter_adminRole_thenOK() {
        String id = "1";
        given().auth().basic("admin", "admin")
                .when().request("GET", "/books/{id}", id).then().statusCode(200);
        given().auth().basic("admin", "admin")
                .when().request("GET", "/edit-book/{id}", id).then().statusCode(200);
    }

    @Test
    public void whenRequestGet_withParameter_userRole_thenOK() {
        String id = "1";
        given().auth().basic("user", "user")
                .when().request("GET", "/books/{id}", id).then().statusCode(200);
        given().auth().basic("user", "user")
                .when().request("GET", "/edit-book/{id}", id).then().statusCode(200);
    }

    @Test
    public void whenRequestGet_addBook_adminRole_thenOK() {

        given().auth().basic("admin", "admin")
                .when()
                .request("GET", "/add-book")
                .then()
                .statusCode(200);
    }

    @Test
    public void whenRequestGet_addBook_userRole_thenForbidden() {

        given().auth().basic("user", "user")
                .when()
                .request("GET", "/add-book")
                .then()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    }

    @Test
    public void whenRequestPost_saveBook_userRole_thenForbidden() {

        given().auth().basic("user", "user")
                .when()
                .request("POST", "/book-save")
                .then()
                .statusCode(403);
    }

    @Test
    public void whenRequestPost_saveBook_userAdmin_thenOK() {
        with().body(new BookDto("1", "title", "author", "sowa", new CategoryDto(1L, "horror"), "desc", new BigDecimal(15.55), 15))
                .given().auth().basic("admin", "admin")
                .when()
                .request("POST", "/book-save")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }


}