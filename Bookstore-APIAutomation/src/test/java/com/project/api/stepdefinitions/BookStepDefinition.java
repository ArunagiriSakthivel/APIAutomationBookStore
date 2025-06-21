package com.project.api.stepdefinitions;

import com.aventstack.extentreports.Status;
import com.project.api.bookmodels.BookModel;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import org.testng.Assert;
import utils.ApiUtils;
import utils.Context;
import utils.TestContext;

import static io.restassured.RestAssured.given;

public class BookStepDefinition {

    private final TestContext testContext;
    private Response response;
    private BookModel requestBook;

    public BookStepDefinition(TestContext context) {
        this.testContext = context;
    }

    @Given("New book with title {string}, author {string}, and year {int}")
    public void new_book_with_title_author_and_year(String title, String author, Integer year) {
        requestBook = new BookModel(title, author, year);
        testContext.getExtentTest().log(Status.INFO, "Creating book: " + requestBook.toString());
    }

    @When("Send a POST request to create the book")
    public void send_a_post_request_to_create_the_book() {
        response = given()
                .contentType("application/json")
                .body(requestBook)
                .when()
                .post(ApiUtils.getBaseUrl() + "/books");

        testContext.setContext(Context.BOOK_ID, response.jsonPath().getInt("id"));
        testContext.getExtentTest().log(Status.INFO, "Response: " + response.asString());
    }

    @Then("Book should be created with response code {int}")
    public void book_should_be_created_with_response_code(Integer statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode.intValue());
        testContext.getExtentTest().log(Status.PASS, "Book created successfully");
    }

    @When("Fetch the book by ID")
    public void fetch_the_book_by_id() {
        int bookId = testContext.getContext(Context.BOOK_ID);
        response = given()
                .when()
                .get(ApiUtils.getBaseUrl() + "/books/" + bookId);

        testContext.getExtentTest().log(Status.INFO, "Fetched book by ID: " + bookId);
    }

    @Then("Response should contain the title {string}")
    public void response_should_contain_the_title(String expectedTitle) {
        String actualTitle = response.jsonPath().getString("title");
        Assert.assertEquals(actualTitle, expectedTitle);
        testContext.getExtentTest().log(Status.PASS, "Book title matched: " + actualTitle);
    }
    
    @Then("Response should contain the author {string}")
    public void response_should_contain_the_author(String string) {
    	 String actualAuthor = response.jsonPath().getString("author");
         Assert.assertEquals(actualAuthor, expectedAuthor);
         testContext.getExtentTest().log(Status.PASS, "Book Author matched: " + actualAuthor);
    }

    @When("Update the book title to {string}")
    public void update_the_book_title_to(String newTitle) {
        int bookId = testContext.getContext(Context.BOOK_ID);
        requestBook.setTitle(newTitle);

        response = given()
                .contentType("application/json")
                .body(requestBook)
                .when()
                .put(ApiUtils.getBaseUrl() + "/books/" + bookId);

        testContext.getExtentTest().log(Status.INFO, "Updated book with new title: " + newTitle);
    }

    @Then("the book should be updated with status code {int}")
    public void book_should_be_updated(Integer statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode.intValue());
        testContext.getExtentTest().log(Status.PASS, "Book updated successfully");
    }

    @When("Delete the book by ID")
    public void delete_the_book_by_id() {
        int bookId = testContext.getContext(Context.BOOK_ID);
        response = given()
                .when()
                .delete(ApiUtils.getBaseUrl() + "/books/" + bookId);

        testContext.getExtentTest().log(Status.INFO, "Deleted book ID: " + bookId);
    }

    @Then("Book should be deleted with response code {int}")
    public void book_should_be_deleted_with_response_code(Integer statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode.intValue());
        testContext.getExtentTest().log(Status.PASS, "Book deleted successfully");
    }

    @When("Try to fetch a non-existent book ID")
    public void try_to_fetch_a_non_existent_book_id() {
        response = given()
                .when()
                .get(ApiUtils.getBaseUrl() + "/books/9999");

        testContext.getExtentTest().log(Status.INFO, "Attempted to fetch non-existent book ID 999");
    }
    
    @Then("Book should not available with response code {int}")
    public void book_should_not_available_with_response_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    	 Assert.assertEquals(response.statusCode(), statusCode.intValue());
    	    testContext.getExtentTest().log(Status.PASS, "Book not available as per the book id");
    }
    
}

    
