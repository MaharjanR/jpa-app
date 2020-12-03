package io.learning.jpaapp.controller;

import io.learning.jpaapp.domain.Book;
import io.learning.jpaapp.exceptions.BookNotFoundExceptions;
import io.learning.jpaapp.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book/")
public class BookController {

    @Autowired
    public BookRepo repo;

    @GetMapping
    public List<Book> getAllBooks(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        Optional<Book> byId = repo.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }else {     
            throw new BookNotFoundExceptions("Book not found of that id");
        }
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return repo.save(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return repo.save(book);
    }

    @DeleteMapping
    public void deleteBook(@RequestBody Book book){
         repo.delete(book);
    }

}
