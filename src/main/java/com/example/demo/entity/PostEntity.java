package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name = "post")
@Getter
@Setter
@Entity
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private UserEntity authorId;
    private Long parentId;
    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private Boolean published;
    private Date createdAt;
    private Date updatedAt;
    private Date publishedAt;
    private String content;

    @JsonIgnore
    @OneToMany(mappedBy = "postEntity")
    private Set<PostCommentEntity> postCommentEntitySet;

    @JsonIgnore
    @OneToMany(mappedBy = "postEntity")
    private Set<PostMetaEntity> postMetaEntitySet;

    @ManyToMany(mappedBy = "PostsInTag")
    Set<TagEntity> TagsInPost;

    @ManyToMany(mappedBy = "PostsInCategory")
    Set<CategoryEntity> CategorysInPost;

}
