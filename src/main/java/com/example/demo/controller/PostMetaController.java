package com.example.demo.controller;

import com.example.demo.entity.PostMetaEntity;
import com.example.demo.service.PostMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.demo.utils.Constants.BASE_API_URL;

@RestController
@RequestMapping(BASE_API_URL + "/post_metas")
public class PostMetaController {
    @Autowired
    PostMetaService postMetaService;

    @GetMapping("")
    public List<PostMetaEntity> list(){return postMetaService.listAllPostMeta();}

    @GetMapping("/{id}")
    public ResponseEntity<PostMetaEntity> get(@PathVariable Long id) {
        Optional<PostMetaEntity> optional = postMetaService.getPostMeta(id);
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody PostMetaEntity PostMetaEntity) {
        postMetaService.savePostMeta(PostMetaEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostMetaEntity> update(@RequestBody PostMetaEntity PostMetaEntity, @PathVariable Long id) {
        Optional<PostMetaEntity> optional = postMetaService.getPostMeta(id);
        if (optional.isPresent()) {
            postMetaService.savePostMeta(PostMetaEntity);
            return new ResponseEntity<>(PostMetaEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postMetaService.deletePostMeta(id);
    }
}
