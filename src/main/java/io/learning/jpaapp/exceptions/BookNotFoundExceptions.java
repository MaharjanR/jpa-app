package io.learning.jpaapp.exceptions;

public class BookNotFoundExceptions extends RuntimeException {

    public BookNotFoundExceptions(String message) {
        super(message);
    }
}
