package io.learning.jpaapp.controller;

import io.learning.jpaapp.domain.Book;
import io.learning.jpaapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String getHome(Model model){
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);
        return "index";
    }
}
