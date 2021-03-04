package com.daa.movieservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/film")
public class MoviePageController {

    @GetMapping("/{id}")
    public ModelAndView film(@PathVariable Long id) {
        return new ModelAndView("movie");
    }
}
