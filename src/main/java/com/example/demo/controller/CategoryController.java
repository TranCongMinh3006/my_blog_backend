package com.example.demo.controller;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.demo.utils.Constants.BASE_API_URL;

@RestController
@RequestMapping(BASE_API_URL + "/categorys")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public List<CategoryEntity> list(){return categoryService.listAllCategory();}

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> get(@PathVariable Long id) {
        Optional<CategoryEntity> optional = categoryService.getCategory(id);
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody CategoryEntity CategoryEntity) {
        categoryService.saveCategory(CategoryEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntity> update(@RequestBody CategoryEntity CategoryEntity, @PathVariable Long id) {
        Optional<CategoryEntity> optional = categoryService.getCategory(id);
        if (optional.isPresent()) {
            categoryService.saveCategory(CategoryEntity);
            return new ResponseEntity<>(CategoryEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
