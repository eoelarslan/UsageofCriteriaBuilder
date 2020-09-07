package com.elarslan.criteriabuilder.repository;

import com.elarslan.criteriabuilder.modal.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MovieRepository{
    EntityManager entityManager;

    public MovieRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Movie> findMoviesByProducerAndGender(Integer producer, Integer genre){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);

        Root<Movie> movie = criteriaQuery.from(Movie.class);
        Predicate producerPredicate = criteriaBuilder.equal(movie.get("producer"),producer);
        Predicate genrePredicate = criteriaBuilder.equal(movie.get("genre"),genre);
        criteriaQuery.where(producerPredicate,genrePredicate);

        TypedQuery<Movie> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    public List<Movie> findMovieByDurationAsc(Integer duration){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);

        Root<Movie> movie = criteriaQuery.from(Movie.class);
        Predicate durationPredicate = criteriaBuilder.greaterThanOrEqualTo(movie.get("duration"),duration);
        criteriaQuery.where(durationPredicate);

        TypedQuery<Movie> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
