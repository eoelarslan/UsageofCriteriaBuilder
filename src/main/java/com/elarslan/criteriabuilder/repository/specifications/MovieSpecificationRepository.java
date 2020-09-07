package com.elarslan.criteriabuilder.repository.specifications;

import com.elarslan.criteriabuilder.modal.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieSpecificationRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {
}
