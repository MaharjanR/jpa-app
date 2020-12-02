package io.learning.jpaapp;

import io.learning.jpaapp.domain.Book;
import io.learning.jpaapp.repo.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaAppApplication {

    BookRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(JpaAppApplication.class, args);
    }

    CommandLineRunner runner(){
        return args -> {

            Book book1 = new Book(1231231l, "Learning React", "Ritesh", "Programming", 500.0);

            repo.save(book1);

        };
    }
}
