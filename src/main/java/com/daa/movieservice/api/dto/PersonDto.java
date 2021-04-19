package com.daa.movieservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PersonDto {
    private String firstName;
    private String lastName;
    private String gender;
    private String biography;
    private Double personHeight;
    private String photo;
    private Set<String> countries;
    private String birthPlace;
    private Date birthDate;
    private Date deathDate;
    private String placeOfDeath;
}
