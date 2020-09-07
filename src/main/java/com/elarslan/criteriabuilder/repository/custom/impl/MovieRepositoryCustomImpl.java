package com.elarslan.criteriabuilder.repository.custom.impl;

import com.elarslan.criteriabuilder.controller.dto.requestdto.MovieSearchRequestDto;
import com.elarslan.criteriabuilder.modal.Movie;
import com.elarslan.criteriabuilder.repository.custom.MovieRepositoryCustom;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MovieRepositoryCustomImpl implements MovieRepositoryCustom {
    EntityManager entityManager;

    public MovieRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Movie> findMovieByFilter(MovieSearchRequestDto searchRequestDto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);

        Root<Movie> movie = criteriaQuery.from(Movie.class);
        List<Predicate> predicates = new ArrayList<>();

        if (searchRequestDto.getGenreId() != null) {
            predicates.add(criteriaBuilder.equal(movie.get("genre"), searchRequestDto.getGenreId()));
        }
        if (searchRequestDto.getProducerId() != null) {
            predicates.add(criteriaBuilder.equal(movie.get("producer"), searchRequestDto.getProducerId()));
        }
        if (searchRequestDto.getName() != null) {
            predicates.add(criteriaBuilder.like(movie.get("name"), "%" +searchRequestDto.getName()+ "%"));
        }
        if (searchRequestDto.getProductionYear() != null) {
            predicates.add(criteriaBuilder.equal(movie.get("productionYear"), searchRequestDto.getProductionYear()));
        }
        if (searchRequestDto.getWriterId() != null) {
            predicates.add(criteriaBuilder.equal(movie.get("writer"), searchRequestDto.getWriterId()));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
