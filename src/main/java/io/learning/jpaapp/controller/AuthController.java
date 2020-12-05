package io.learning.jpaapp.controller;

import io.learning.jpaapp.domain.Author;
import io.learning.jpaapp.domain.Book;
import io.learning.jpaapp.domain.ErrorResponse;
import io.learning.jpaapp.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Author")
@RestController()
@RequestMapping("/api/author")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = Author.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)
    })
    @GetMapping
    public List<Author> getAllAuthor(){
       return authService.getAllAuthor();
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = Author.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "ID not found ", response = ErrorResponse.class)
    })
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id){
        return authService.getAuthorById(id);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = Author.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)
    })
    @PutMapping
    public Author updateAuthor(@RequestBody Author author){
        return authService.createAuthor(author);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 201, message = "Created", response = Author.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)
    })
    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authService.createAuthor(author);
    }
}
