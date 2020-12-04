package io.learning.jpaapp.controller;

import io.learning.jpaapp.domain.Book;
import io.learning.jpaapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return service.createBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return service.createBook(book);
    }
}
