package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "post_comment")
@Setter
@Getter
@Entity
public class PostCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity postEntity;
    private Long parentId;
    private String title;
    private Boolean published;
    private Date createdAt;
    private Date publishedAt;
    private String content;
}
