package com.elarslan.criteriabuilder.controller;

import com.elarslan.criteriabuilder.controller.dto.base.GenericResponseDto;
import com.elarslan.criteriabuilder.controller.dto.requestdto.MovieSearchRequestDto;
import com.elarslan.criteriabuilder.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/searchMovie")
    public ResponseEntity<?> getMovieDetail(@RequestBody MovieSearchRequestDto searchRequestDto) {
        return ResponseEntity.ok().body(new GenericResponseDto<>(HttpStatus.OK,
                "Detail retrieved", movieService.retrieveMovieDetail(searchRequestDto)));
    }
    @GetMapping("/searchMovieByDuration")
    public ResponseEntity<?> getMovieDetailDurationAsc(@RequestParam(name = "duration") Long duration) {
        return ResponseEntity.ok().body(new GenericResponseDto<>(HttpStatus.OK,
                "Detail retrieved", movieService.retrieveMovieDetailByDuration(Math.toIntExact(duration))));
    }
    @GetMapping("/searchMovieByFilter")
    public ResponseEntity<?> getMovieDetailByFilter(@RequestBody MovieSearchRequestDto searchRequestDto) {
        return ResponseEntity.ok().body(new GenericResponseDto<>(HttpStatus.OK,
                "Detail retrieved", movieService.retrieveMovieDetailByFilter(searchRequestDto)));
    }
    @GetMapping("/searchMovieUsingSpecification")
    public ResponseEntity<?> getMovieDetailUsingSpecification(@RequestBody MovieSearchRequestDto searchRequestDto) {
        return ResponseEntity.ok().body(new GenericResponseDto<>(HttpStatus.OK,
                "Detail retrieved", movieService.retrieveMovieDetailUsingSpecification(searchRequestDto)));
    }
}
