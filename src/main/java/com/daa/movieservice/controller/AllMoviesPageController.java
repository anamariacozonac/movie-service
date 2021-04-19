package com.daa.movieservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/movies")
@RequiredArgsConstructor
public class AllMoviesPageController {

    @GetMapping
    public ModelAndView index() throws Exception{
        return new ModelAndView("all_movies.html");
    }
}