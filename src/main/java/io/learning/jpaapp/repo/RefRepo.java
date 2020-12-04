package io.learning.jpaapp.repo;

import io.learning.jpaapp.domain.RefData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefRepo extends JpaRepository<RefData, Long> {
}
