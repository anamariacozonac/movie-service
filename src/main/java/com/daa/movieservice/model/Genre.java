package com.daa.movieservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_genres")
@AllArgsConstructor
@NoArgsConstructor
public class Genre {

    @Id
    private Long id;

    @Column(name = "genre_name")
    private String genreName;

    @ManyToOne
    @JoinTable(name = "t_movies_genres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Movie movies;

}
