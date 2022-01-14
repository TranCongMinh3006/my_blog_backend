package com.example.demo.service;

import com.example.demo.entity.PostEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public List<UserEntity> listAllUser() {
        return userRepository.findAll();
    }

    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public Optional<UserEntity> getUser(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<PostEntity> getPostsOfUser(UserEntity id) {
        return postRepository.findByAuthorId(id);
    }
}
