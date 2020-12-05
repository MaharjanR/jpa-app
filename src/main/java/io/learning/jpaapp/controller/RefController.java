package io.learning.jpaapp.controller;

import io.learning.jpaapp.domain.Book;
import io.learning.jpaapp.domain.ErrorResponse;
import io.learning.jpaapp.domain.RefData;
import io.learning.jpaapp.exceptions.RefDataExceptions;
import io.learning.jpaapp.repo.RefRepo;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ref")
public class RefController {

    @Autowired
    private RefRepo refRepo;

    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = RefData.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)
    })
    @GetMapping
    public List<RefData> findAll(){
        return refRepo.findAll();
    }

    @ApiResponses({
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Method not implemented", response = ErrorResponse.class)
    })
    @PostMapping
    public void create(){
        throw new RefDataExceptions("Method not implemented");
    }
}
