@book @QA @CRUD
Feature: Bookstore API Functionality validation
  
  This feature tests the CRUD functions of manage Book API.

  @create @positive
  Scenario: Create a new book
    Given New book with title "DaVinci Code", author "Dan Brown", and year 2000
    When Send a POST request to create the book
    Then Book should be created with response code 201

  @read @positive @regression
  Scenario: Fetch the created book by ID
    Given New book with title "Jane Eyre", author "Jane Austen", and year 1999
    When Send a POST request to create the book
    Then The book should be created with response code 201
    When Fetch the book by ID
    Then Response should contain the author "Jane Austen"

  @read @positive @regression
  Scenario: Fetch the created book by ID
    Given New book with title "Beautiful Tale", author "Darren Mop", and year 1997
    When Send a POST request to create the book
    Then The book should be created with response code 201
    When Fetch the book by ID
    Then Response should contain the title "Beautiful Tale"

  @update @positive @regression
  Scenario: Update the book title
    Given a new book with title "Clean Code", author "Robert C. Martin", and year 2008
    When I send a POST request to create the book
    Then Book should be created with status code 201
    When Update the book title to "Clean Code (2nd Edition)"
    Then Book should be updated with response code 200
    When Fetch the book by ID
    Then Response should contain the title "Clean Code (2nd Edition)"

  @delete @positive @regression
  Scenario: Delete an already availabe book from store
    Given New book with title "Bourne Idemtity", author "Robert Ludlum", and year 2003
    When Send a POST request to create the book
    Then Book should be created with response code 201
    When Delete the book by ID
    Then Book should be deleted with response code 204

  @delete @positive @regression
  Scenario: Delete an already availabe book from store
    Given New book with title "The Match", author "Charles Dickens", and year 2003
    When Send a POST request to create the book
    Then Book should be created with response code 201
    When Delete the book by ID
    Then Book should be deleted with response code 204

  @read @negative
  Scenario: Fetch a not available book by ID
    When Try to fetch a non-existent book ID
    Then Book should not available with response code 404
