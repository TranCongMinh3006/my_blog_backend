package com.example.demo.service;

import com.example.demo.entity.PostEntity;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<PostEntity> listAllPost(){return postRepository.findAll();}

    public void savePost(PostEntity postEntity){postRepository.save(postEntity);}

    public Optional<PostEntity> getPost(Long id){return postRepository.findById(id);}

    public void deletePost(Long id){postRepository.deleteById(id);}
}
