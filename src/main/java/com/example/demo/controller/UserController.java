package com.example.demo.controller;

import com.example.demo.entity.PostEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.demo.utils.Constants.BASE_API_URL;

@RestController
@RequestMapping(BASE_API_URL + "/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<UserEntity> list() {
        return userService.listAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> get(@PathVariable Long id) {
        Optional<UserEntity> optional = userService.getUser(id);
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody UserEntity userEntity) {
        userService.saveUser(userEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> update(@RequestBody UserEntity postEntity, @PathVariable Long id) {
        Optional<UserEntity> optional = userService.getUser(id);
        if (optional.isPresent()) {
            userService.saveUser(postEntity);
            return new ResponseEntity<>(postEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/posts")
    public List<PostEntity> list(@PathVariable Long id ) {
        UserEntity userEntity = new UserEntity(id);
        return userService.getPostsOfUser(userEntity);
    }
}
