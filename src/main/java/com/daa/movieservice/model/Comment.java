package com.daa.movieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "t_comments")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "comment_date")
    private Date commentDate;

    @Column(name = "positive_review_rating")
    private Integer positiveCommentRating;

    @Column(name = "negative_review_rating")
    private Integer negativeCommentRating;

    @ManyToOne
    private User user;
}
