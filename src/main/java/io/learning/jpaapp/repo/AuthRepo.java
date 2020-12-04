package io.learning.jpaapp.repo;

import io.learning.jpaapp.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<Author, Long> {
}
