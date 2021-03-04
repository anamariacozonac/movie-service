package com.daa.movieservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_movies_t_persons_roles")
@AllArgsConstructor
@NoArgsConstructor
public class PersonRole {

    @Id
    private Long id;

}
