package com.example.demo.controller;

import com.example.demo.entity.TagEntity;
import com.example.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.demo.utils.Constants.BASE_API_URL;

@RestController
@RequestMapping(BASE_API_URL + "/tags")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("")
    public List<TagEntity> list(){return tagService.listAllTag();}

    @GetMapping("/{id}")
    public ResponseEntity<TagEntity> get(@PathVariable Long id) {
        Optional<TagEntity> optional = tagService.getTag(id);
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody TagEntity TagEntity) {
        tagService.saveTag(TagEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagEntity> update(@RequestBody TagEntity TagEntity, @PathVariable Long id) {
        Optional<TagEntity> optional = tagService.getTag(id);
        if (optional.isPresent()) {
            tagService.saveTag(TagEntity);
            return new ResponseEntity<>(TagEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tagService.deleteTag(id);
    }
}
