package io.learning.jpaapp.controller;

import io.learning.jpaapp.domain.ErrorResponse;
import io.learning.jpaapp.exceptions.AuthorNotFoundExceptions;
import io.learning.jpaapp.exceptions.BookNotFoundExceptions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

// This is going to get called everytime there is an exception to see if there is a handler
@RestController
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {


    @ExceptionHandler({BookNotFoundExceptions.class, AuthorNotFoundExceptions.class})
    protected ResponseEntity<Object> bookNotFound(RuntimeException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse(ex.getMessage(), LocalDateTime.now(), "NOT FOUND");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
