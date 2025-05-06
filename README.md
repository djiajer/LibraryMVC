# Spring Course. Practical Project 1 & 2.
This educational project was developed as part of the Spring Framework course on Udemy (https://www.udemy.com/course/spring-alishev/). This is a CRUD web application for library management.

The project was created with Spring MVC, Maven for building and dependency injection,
PostgreSQL database + Hibernate Validator, deployed on Tomcat servlet container, Thymeleaf + HTML5 for a simple frontend. First project used JDBC API for collaboration with database. The second project 
was to re-write all this logic to Spring data JPA and Hibernate ORM.


## Features
- Reader management (CRUD operations)
- Book management (CRUD operations)
- Book lending and returning
- Book pagination - `/books?page=1&books_per_page=3`
- Book sorting - `/books?sort_by_year=true`
- Book search - `/books/search` (by title prefix)
- Overdue check - books not returned for more than 10 days are highlighted in red

## Interface Screenshots
- List of all readers (`/people`)
- List of all books (`/books`)
- Reader's page with their books (`/people/{id}`)
- Book page with lending/returning options (`/books/{id}`)

## API Endpoints

### For Reader Operations:
- `GET /people` - List all readers
- `GET /people/new` - Add new reader form
- `POST /people` - Create a reader
- `GET /people/{id}/edit` - Edit reader form
- `PATCH /people/{id}` - Update a reader
- `DELETE /people/{id}` - Delete a reader

### For Book Operations:
- `GET /books` - List all books (with pagination and sorting)
- `GET /books/search` - Search books by title
- `GET /books/new` - Add new book form
- `POST /books` - Create a book
- `GET /books/{id}/edit` - Edit book form
- `PATCH /books/{id}` - Update a book
- `DELETE /books/{id}` - Delete a book
- `PATCH /books/{id}/assign` - Assign book to a reader
- `PATCH /books/{id}/release` - Return book to the library

## Implementation Details
- Pagination using Spring Data's Pageable interface
- Sorting via query parameters
- Search using repository method `findByTitleStartingWith()`
- Overdue check via `@Transient` field and service method
- Form field validation for all inputs
