package com.daa.movieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "t_articles")
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    private Long id;

    @Column(name = "article_title")
    private String articleTitle;

    @Column(name = "content")
    private String content;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "movie_score")
    private Integer movieScore;

    @Column(name = "positive_review_rating")
    private  Integer positiveRevRating;

    @Column(name = "negative_review_rating")
    private  Integer negativeRevRating;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_article_comments",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private Set<Comment> comments;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;


}
