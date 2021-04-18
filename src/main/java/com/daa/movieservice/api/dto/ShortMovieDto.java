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
public class ShortMovieDto {
    private Long id;
    private String movTitle;
    private String movIcon;
    private Integer rating;
    private Set<String> genres;
    private Set<String> countries;
    private String origName;
    private Date year;
}
