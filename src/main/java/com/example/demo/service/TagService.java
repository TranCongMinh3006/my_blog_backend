package com.example.demo.service;

import com.example.demo.entity.PostEntity;
import com.example.demo.entity.TagEntity;
import com.example.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<TagEntity> listAllTag() {
        return tagRepository.findAll();
    }

    public void saveTag(TagEntity tagEntity) {
        tagRepository.save(tagEntity);
    }

    public Optional<TagEntity> getTag(Long id) {
        return tagRepository.findById(id);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

}
