package io.learning.jpaapp.service;

import io.learning.jpaapp.domain.Author;
import io.learning.jpaapp.domain.Book;
import io.learning.jpaapp.exceptions.AuthorNotFoundExceptions;
import io.learning.jpaapp.exceptions.BookNotFoundExceptions;
import io.learning.jpaapp.repo.AuthRepo;
import io.learning.jpaapp.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    public BookRepo bookRepo;
    public AuthRepo authRepo;

    public BookService(BookRepo bookRepo, AuthRepo authRepo) {
        this.bookRepo = bookRepo;
        this.authRepo = authRepo;
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Book getBookById(long id) {
        Optional<Book> byId = bookRepo.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }else {
            throw new BookNotFoundExceptions("Book not found of id" + id);
        }
    }

    public Book createBook(Book book){
        Long id = book.getAuthor().getId();
        Optional<Author> author = authRepo.findById(id);

        if(!authRepo.findById(id).isPresent()){
            throw new AuthorNotFoundExceptions("Author is not present");
        }
        book.setAuthor(author.get());
        return bookRepo.save(book);
    }

}
