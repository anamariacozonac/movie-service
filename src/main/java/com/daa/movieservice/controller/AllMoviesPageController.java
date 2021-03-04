package com.daa.movieservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/movies")
public class AllMoviesPageController {

    @GetMapping
    public ModelAndView movies(){
        return new ModelAndView("all_movies");
    }
}
