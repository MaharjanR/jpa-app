package io.learning.jpaapp.controller;

import io.learning.jpaapp.domain.Author;
import io.learning.jpaapp.service.AuthService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Author")
@RestController()
@RequestMapping("/api/author")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping
    public List<Author> getAllAuthor(){
       return authService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id){
        return authService.getAuthorById(id);
    }

    @PutMapping
    public Author updateAuthor(@RequestBody Author author){
        return authService.createAuthor(author);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authService.createAuthor(author);
    }
}
