package io.learning.jpaapp.controller;

import io.learning.jpaapp.domain.Book;
import io.learning.jpaapp.domain.ErrorResponse;
import io.learning.jpaapp.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "Book")
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    public BookService service;


    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = Book.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)
    })
    @GetMapping
    public List<Book> getAllBooks( @RequestParam(value= "price", required = false) Double price){
        System.out.println(price);
        if(price == null){
            return service.getAllBooks();
        }else{
            return  service.getAllByPrice(price);
        }
    }


    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = Book.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Book with ID not found", response = ErrorResponse.class)
    })
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return service.getBookById(id);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 201, message = "Created", response = Book.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)
    })
    @PostMapping
    public Book createBook(@RequestBody Book book){
        return service.createBook(book);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = Book.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)
    })
    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return service.createBook(book);
    }
}
