package com.daa.movieservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "t_countries")
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    private Long id;

    @Column(name = "country_name")
    private String countryName;

    @Override
    public String toString() {
        return countryName;
    }

    @ManyToOne
    @JoinTable(name = "t_movies_countries",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Movie movies;


    @ManyToOne
    @JoinTable(name = "t_persons_countries",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Person person;
}
