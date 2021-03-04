package com.daa.movieservice.service;

import com.daa.movieservice.model.Movie;
import com.daa.movieservice.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;


    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }


}
