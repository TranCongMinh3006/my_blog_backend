package com.example.demo.repository;

import com.example.demo.entity.PostEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findByAuthorId(UserEntity id);
}
