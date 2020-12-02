package io.learning.jpaapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="table_author")
@NoArgsConstructor
@Data
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="author_id")
    private Long id;
    @Column(nullable = false)
    private String name;
    private String company;
    private String institution;
    private Date createDate;
    private Date updateDate;
    private StatusEnum statusEnum;

    public Author(String name, String company, String institution, Date createDate, Date updateDate, StatusEnum statusEnum) {
        this.name = name;
        this.company = company;
        this.institution = institution;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.statusEnum = statusEnum;
    }
}
