package io.learning.jpaapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sun.security.util.Length;

import javax.persistence.*;

@Entity
@Table(name="table_book")
@NoArgsConstructor
@Data
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    private Long id;
    private Long isbn;

    @Column(length=255)
    private String title;
    private String author;
    private String category;
    private Double price;

    public Book(Long isbn, String title, String author, String category, Double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }
}
