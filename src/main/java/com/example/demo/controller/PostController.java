package com.example.demo.controller;

import com.example.demo.entity.PostEntity;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.demo.utils.Constants.BASE_API_URL;

@RestController
@RequestMapping(BASE_API_URL + "/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("")
    public List<PostEntity> list(){return postService.listAllPost();}

    @GetMapping("/{id}")
    public ResponseEntity<PostEntity> get(@PathVariable Long id) {
        Optional<PostEntity> optional = postService.getPost(id);
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody PostEntity postEntity) {
        postService.savePost(postEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostEntity> update(@RequestBody PostEntity postEntity, @PathVariable Long id) {
        Optional<PostEntity> optional = postService.getPost(id);
        if (optional.isPresent()) {
            postService.savePost(postEntity);
            return new ResponseEntity<>(postEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
