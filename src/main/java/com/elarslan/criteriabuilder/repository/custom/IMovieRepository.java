package com.elarslan.criteriabuilder.repository.custom;

import com.elarslan.criteriabuilder.modal.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long>, MovieRepositoryCustom {
}
