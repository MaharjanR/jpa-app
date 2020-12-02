package io.learning.jpaapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Book")
@NoArgsConstructor
@Data
@ToString
public class Book {

}
