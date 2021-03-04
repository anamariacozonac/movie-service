package com.daa.movieservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@Table( name = "t_reviews")
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

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;

}

