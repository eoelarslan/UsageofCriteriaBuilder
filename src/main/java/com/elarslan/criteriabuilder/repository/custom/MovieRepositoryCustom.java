package com.elarslan.criteriabuilder.repository.custom;

import com.elarslan.criteriabuilder.controller.dto.requestdto.MovieSearchRequestDto;
import com.elarslan.criteriabuilder.modal.Movie;

import java.util.List;

/**
 * Created by ersin on 22.11.2019.
 */
public interface MovieRepositoryCustom {
    List<Movie> findMovieByFilter(MovieSearchRequestDto searchRequestDto);
}
