package com.daa.movieservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ReviewDto {
    private Long id;
    private String reviewTitle;
    private Long positiveRevRatting;
    private Long negativeRevRatting;
    private Date publicationDate;
    private String content;
    private Integer movieScore;
}
