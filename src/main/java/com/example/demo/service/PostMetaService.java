package com.example.demo.service;

import com.example.demo.entity.PostMetaEntity;
import com.example.demo.repository.PostMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostMetaService {
    @Autowired
    private PostMetaRepository postMetaRepository;

    public List<PostMetaEntity> listAllPostMeta(){return postMetaRepository.findAll();}

    public void savePostMeta(PostMetaEntity postMetaEntity){postMetaRepository.save(postMetaEntity);}

    public Optional<PostMetaEntity> getPostMeta(Long id){return postMetaRepository.findById(id);}

    public void deletePostMeta(Long id){postMetaRepository.deleteById(id);}
}