package com.daa.movieservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "t_movies")
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private Long id;

    @Column(name = "movie_title")
    private String movieTitle;

    @Column(name = "description")
    private String description;

    @Column(name = "slogan")
    private String slogan;

    @Column(name = "budget")
    private Integer budget;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "premiere_date")
    private Date premiereDate;

    @Column(name = "year_of_production")
    private Date yearOfProduction;

    @Column(name = "box_office")
    private Integer boxOffice;

    @Column(name = "rating_mppa")
    private String ratingMppa;

    @Column(name = "original_language")
    private String originalLanguage;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_movies_countries",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    @JsonManagedReference
    private Set<Country> countries;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_movies_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @JsonManagedReference
    private Set<Genre> genres;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_movies_companies",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    @JsonManagedReference
    private Set<Company> companies;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    @JsonManagedReference
    private Set<Review> reviews;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    @JsonManagedReference
    private Set<Article> articles;

}
