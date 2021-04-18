package com.daa.movieservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

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

    @Column(name = "positive_comment_rating")
    private Integer positiveCommentRating;

    @Column(name = "negative_comment_rating")
    private Integer negativeCommentRating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private User user;
}
