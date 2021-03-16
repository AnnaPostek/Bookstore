## Bookstore

Bookstore project is CRUD application. It helps management of books helds on stock for booksellers. 
Application is using Java 11, Spring Boot, Maven, JUnit, H2, Lombok, JPA, Spring Security, Swagger

## Installation
In the beggining of instalation you need to install java 11 and maven

[Maven](https://maven.apache.org/download.cgi)
[Java 11](https://adoptopenjdk.net/)

After that run the following commands:
mvn clean install
java -jar target/final_shop-0.0.1-SNAPSHOT.jar

## Web
Application is available on below localhost:
http://localhost:8080/

# Endpoints:
GET /all-books - get list of all books

GET /books/{id} display book by Id

GET /add-book - add book

POST /book-save - save book in entity

GET /edit-book/{id} - edit book with id

GET /all-categories - get list of allcategories, which is in data.sql

# Users
User which has permission for all functionalities:
-admin-
password 
-admin- 

user without moderation mode:
-user-
password
-user-
has access to /all-books

the rest endpoints can be use for everyone without log in


