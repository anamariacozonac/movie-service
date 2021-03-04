package com.daa.movieservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/person")
public class PersonPageController {

    @GetMapping("/{id}")
    public ModelAndView person(@PathVariable Long id){
        return new ModelAndView("person");
    }
}
