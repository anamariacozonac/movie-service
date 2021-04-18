package com.daa.movieservice.service;

import com.daa.movieservice.api.dto.CrewDto;
import com.daa.movieservice.api.dto.MovieDto;
import com.daa.movieservice.api.dto.ReviewDto;
import com.daa.movieservice.api.dto.ShortMovieDto;
import com.daa.movieservice.model.Movie;
import com.daa.movieservice.repository.MovieRepository;
import com.daa.movieservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.daa.movieservice.utils.MovieMapper.*;

@Service
@RequiredArgsConstructor
public class MovieService {
    @Autowired
    private final MovieRepository movieRepository;
    @Autowired
    private final ReviewRepository reviewRepository;


    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }


    public MovieDto getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.map(mapMovieToMovieDto).get();
    }

    public List<CrewDto> getMovScore(Long id) { // todo change return type and add implementation
        return null;
    }


    public MovieDto getMovById(Long id) {
        return movieRepository
                .findById(id)
                .map(mapMovieToMovieDto)
                .get();
    }

    public List<ReviewDto> getReviews(Long id) {
        return reviewRepository.findReviewByMovieId(id)
                .stream()
                .map(mapReviewToReviewDto)
                .collect(Collectors.toList());
    }

    public List<ShortMovieDto> getTopMovies(Integer number) {
        return movieRepository.getTop(number)
                .stream()
                .map(mapMovieToShortMovieDto)
                .collect(Collectors.toList());
    }
}
