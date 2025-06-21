package com.project.api.utility;

import com.project.api.bookmodels.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredUtility {

    public static Response createBook(BookModel book) {
        return given()
                .contentType("application/json")
                .body(book)
                .when()
                .post("/users")
                .then()
                .extract()
                .response();
    }

    public static Response getBookById(String id) {
        return given()
                .contentType("application/json")
                .when()
                .get("/users/" + id)
                .then()
                .extract()
                .response();
    }

    public static Response updateBook(String id, BookModel book) {
        return given()
                .contentType("application/json")
                .body(book)
                .when()
                .put("/users/" + id)
                .then()
                .extract()
                .response();
    }

    public static Response deleteBook(String id) {
        return given()
                .contentType("application/json")
                .when()
                .delete("/users/" + id)
                .then()
                .extract()
                .response();
    }
}

