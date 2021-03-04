package com.daa.movieservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_roles")
@AllArgsConstructor
@RequiredArgsConstructor
public class Role {

    @Id
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @ManyToOne
    @JoinTable(name = "t_person_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    @JsonBackReference
    private Person person;
}
