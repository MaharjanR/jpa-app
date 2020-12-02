package io.learning.jpaapp;

import io.learning.jpaapp.domain.Book;
import io.learning.jpaapp.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaAppApplication {

    @Autowired
    BookRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(JpaAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {

//          create
            Book book1 = new Book(1231231l, "Learning React", "Ritesh", "Programming", 500.0);
            System.out.println(book1);
            repo.save(book1);
            repo.save(new Book(12345678l, "Learning Java", "Safal", "Programming", 5200.0));
            repo.save(new Book(9876543l, "Learning Spring Boot", "Rag", "Programming", 200.0));

//          Update
            book1.setTitle("Learning JavaScript");
            repo.save(book1);

//          delete
            repo.delete(book1);

            System.out.println(repo.countAll());
            System.out.println(repo.getBooksByPriceLessThan(5200.0));
        };
    }
}
