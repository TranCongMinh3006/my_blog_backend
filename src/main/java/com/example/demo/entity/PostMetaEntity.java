package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "post_meta")
@Entity
@Setter
@Getter
public class PostMetaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity postEntity;
    private String key;
    private String content;
}
