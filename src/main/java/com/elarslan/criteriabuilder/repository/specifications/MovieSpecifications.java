package com.elarslan.criteriabuilder.repository.specifications;

import com.elarslan.criteriabuilder.modal.Movie;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MovieSpecifications {
    public static Specification<Movie> hasProducer(String producer) {
        return (movie, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(movie.get("producer"), producer);
    }
    public static Specification<Movie> nameContains(String movieName) {
        return (movie, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(movie.get("name"), "%" + movieName + "%");
    }
    public static Specification<Movie> isDurationGreater(String duration) {
        return (movie, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(movie.get("duration"), duration);
    }
    public static Specification<Movie> isDurationEqual(String duration) {
        return (movie, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(movie.get("duration"), duration);
    }
    public static Specification<Movie> hasGenre(Integer genre) {
        return (movie, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(movie.get("genre"), genre);
    }
    public static Specification<Movie> isProductionYearLess(Integer productionYear) {
        return (movie, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(movie.get("productionYear"), productionYear);
    }
}
