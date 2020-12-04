package io.learning.jpaapp.exceptions;

public class AuthorNotFoundExceptions extends RuntimeException{

    public AuthorNotFoundExceptions(String message) {
        super(message);
    }
}
