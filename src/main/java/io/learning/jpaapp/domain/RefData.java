package io.learning.jpaapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class RefData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ref_id")
    private Long id;
    private String name;
    private String value;

    public RefData(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
