package com.daa.movieservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

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

    @Column(name = "positive_article_rating")
    private  Integer positiveRevRating;

    @Column(name = "negative_article_rating")
    private  Integer negativeRevRating;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_article_comments",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private User user;


}
