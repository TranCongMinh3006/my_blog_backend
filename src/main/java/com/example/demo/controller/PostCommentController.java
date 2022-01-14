package com.example.demo.controller;

import com.example.demo.entity.PostCommentEntity;
import com.example.demo.service.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.demo.utils.Constants.BASE_API_URL;

@RestController
@RequestMapping(BASE_API_URL + "/post_comments")
public class PostCommentController {
    @Autowired
    PostCommentService postCommentService;

    @GetMapping("")
    public List<PostCommentEntity> list(){return postCommentService.listAllPostComment();}

    @GetMapping("/{id}")
    public ResponseEntity<PostCommentEntity> get(@PathVariable Long id) {
        Optional<PostCommentEntity> optional = postCommentService.getPostComment(id);
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody PostCommentEntity PostCommentEntity) {
        postCommentService.savePostComment(PostCommentEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostCommentEntity> update(@RequestBody PostCommentEntity PostCommentEntity, @PathVariable Long id) {
        Optional<PostCommentEntity> optional = postCommentService.getPostComment(id);
        if (optional.isPresent()) {
            postCommentService.savePostComment(PostCommentEntity);
            return new ResponseEntity<>(PostCommentEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postCommentService.deletePostComment(id);
    }
}