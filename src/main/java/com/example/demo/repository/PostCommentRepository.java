package com.example.demo.repository;

import com.example.demo.entity.PostCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostCommentEntity, Long> {
}
