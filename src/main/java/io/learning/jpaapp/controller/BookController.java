package io.learning.jpaapp.controller;

import io.learning.jpaapp.domain.Book;
import io.learning.jpaapp.domain.ErrorResponse;
import io.learning.jpaapp.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "Book")
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    public BookService service;

    @GetMapping
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return service.getBookById(id);
    }

    @ApiResponses({
            @ApiResponse(code = 201, message = "Created", response = Book.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)
    })
    @PostMapping
    public Book createBook(@RequestBody Book book){
        return service.createBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return service.createBook(book);
    }
}
