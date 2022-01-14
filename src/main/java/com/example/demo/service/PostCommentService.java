package com.example.demo.service;

import com.example.demo.entity.PostCommentEntity;
import com.example.demo.repository.PostCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostCommentService {
    @Autowired
    private PostCommentRepository postCommentRepository;

    public List<PostCommentEntity> listAllPostComment(){return postCommentRepository.findAll();}

    public void savePostComment(PostCommentEntity postCommentEntity){postCommentRepository.save(postCommentEntity);}

    public Optional<PostCommentEntity> getPostComment(Long id){return postCommentRepository.findById(id);}

    public void deletePostComment(Long id){postCommentRepository.deleteById(id);}
}
