package com.daa.movieservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_companies")
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @ManyToOne
    @JoinTable(name = "t_movies_companies",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Movie movies;

}
