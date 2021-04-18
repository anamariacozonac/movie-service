package com.daa.movieservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CrewDto {
    private Long id;
    private String name;
    private String roleName;
    private String personageName;
    private String movieTitle;
}
