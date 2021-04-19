package com.daa.movieservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @GetMapping("/movie")
    public ModelAndView adminAddMovie(){
        return new ModelAndView("admin_add_movie.html");
    }

    @GetMapping("/person")
    public ModelAndView adminAddPerson(){
        return new ModelAndView("admin_add_person.html");
    }
}
