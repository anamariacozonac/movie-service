package com.daa.movieservice.api.restcontroller;

import com.daa.movieservice.model.Movie;
import com.daa.movieservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/all")
    public List<Movie> getAllMovies(){
        return movieService.getMovies();
    }

}
