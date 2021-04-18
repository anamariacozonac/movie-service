package com.daa.movieservice.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "t_reviews")
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private Long id;

    @Column(name = "review_title")
    private String reviewTitle;

    @Column(name = "content")
    private String content;

    @Column(name = "movie_score")
    private Integer movieScore;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "positive_review_rating")
    private Long positiveReviewRating;

    @Column(name = "negative_review_rating")
    private Long negativeReviewRating;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_review_comments",
            joinColumns = @JoinColumn(name = "review_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private Set<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    @JsonBackReference
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}

