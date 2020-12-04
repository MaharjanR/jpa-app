package io.learning.jpaapp;

import io.learning.jpaapp.domain.Author;
import io.learning.jpaapp.domain.Book;
import io.learning.jpaapp.domain.StatusEnum;
import io.learning.jpaapp.repo.AuthRepo;
import io.learning.jpaapp.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class JpaAppApplication {

    @Autowired
    BookRepo repo;
    @Autowired
    AuthRepo authRepo;

    public static void main(String[] args) {
        SpringApplication.run(JpaAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {

            Author a1= new Author("Ritesh", "Valve", null, new Date(), new Date(), StatusEnum.ACTIVE);
            Author a2= new Author("Safal", "Google", null, new Date(), new Date(), StatusEnum.ACTIVE);
            Author a3= new Author("Saurav", "Intel", null, new Date(), new Date(), StatusEnum.ACTIVE);
//            Author a4= new Author("Raj", "Samsung", null, new Date(), new Date(), StatusEnum.SUSPENDED);

            authRepo.save(a1);
            authRepo.save(a2);
            authRepo.save(a3);
//          create
            Book book1 = new Book(1231231l, "Learning React", a1, "Programming", 500.0);
            System.out.println(book1);
            repo.save(book1);
            repo.save(new Book(12345678l, "Learning Java", a2, "Programming", 5200.0));
            repo.save(new Book(9876543l, "Learning Spring Boot", a3, "Programming", 200.0));

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
