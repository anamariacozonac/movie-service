package com.daa.movieservice.api.restcontroller;

import com.daa.movieservice.model.Person;
import com.daa.movieservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/all")
    public List<Person> getPersons(){
        return personService.getPersons();
    }

//    @GetMapping("/{id}")
//    public Person getPersonById(@PathVariable Long id){
//        return personService.getPersonById(id);
//    }
}
