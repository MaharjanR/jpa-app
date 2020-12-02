package io.learning.jpaapp.repo;

import io.learning.jpaapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

//    @Query("select count(a) from  Book a")
//    long countAll();


    @Query(value = "select count(*) from  table_book", nativeQuery = true)
    long countAll();

    @Query(value = "SELECT * FROM table_book WHERE price < :price", nativeQuery = true)
    List<Book> getBooksByPriceLessThan(@Param("price")double price);
}
