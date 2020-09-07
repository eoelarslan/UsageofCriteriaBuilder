package com.elarslan.criteriabuilder.service;

import com.elarslan.criteriabuilder.controller.dto.requestdto.MovieSearchRequestDto;
import com.elarslan.criteriabuilder.controller.dto.responsedto.MovieSearchResponseDto;
import com.elarslan.criteriabuilder.repository.MovieRepository;
import com.elarslan.criteriabuilder.repository.custom.IMovieRepository;
import com.elarslan.criteriabuilder.repository.specifications.MovieSpecificationRepository;
import com.elarslan.criteriabuilder.repository.specifications.MovieSpecifications;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.Specification.where;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IMovieRepository iMovieRepository;

    @Autowired
    MovieSpecificationRepository specificationRepository;

    MovieSpecifications movieSpecification;

    public MovieService(MovieSpecifications movieSpecification) {
        this.movieSpecification = movieSpecification;
    }

    public List<MovieSearchResponseDto> retrieveMovieDetail(MovieSearchRequestDto searchRequestDto) {
        return movieRepository.findMoviesByProducerAndGender(searchRequestDto.getProducerId(), searchRequestDto.getGenreId())
                .stream()
                .map(movie -> modelMapper.map(movie, MovieSearchResponseDto.class))
                .collect(Collectors.toList());
    }
    public List<MovieSearchResponseDto> retrieveMovieDetailByDuration(Integer duration) {
        return movieRepository.findMovieByDurationAsc(duration)
                .stream()
                .map(movie -> modelMapper.map(movie, MovieSearchResponseDto.class))
                .collect(Collectors.toList());
    }
    public List<MovieSearchResponseDto> retrieveMovieDetailByFilter(MovieSearchRequestDto searchRequestDto) {
        return iMovieRepository.findMovieByFilter(searchRequestDto)
                .stream()
                .map(movie -> modelMapper.map(movie, MovieSearchResponseDto.class))
                .collect(Collectors.toList());
    }
    public List<MovieSearchResponseDto> retrieveMovieDetailUsingSpecification(MovieSearchRequestDto searchRequestDto) {
        return specificationRepository.findAll(where(MovieSpecifications.hasGenre(searchRequestDto.getGenreId())
        .or(MovieSpecifications.isProductionYearLess(Integer.valueOf(searchRequestDto.getProductionYear())))))
                .stream()
                .map(movie -> modelMapper.map(movie,MovieSearchResponseDto.class))
                .collect(Collectors.toList());
    }
}
