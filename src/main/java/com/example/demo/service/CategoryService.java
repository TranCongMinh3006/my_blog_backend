package com.example.demo.service;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> listAllCategory(){return categoryRepository.findAll();}

    public void saveCategory(CategoryEntity categoryEntity){categoryRepository.save(categoryEntity);}

    public Optional<CategoryEntity> getCategory(Long id){return categoryRepository.findById(id);}

    public void deleteCategory(Long id){categoryRepository.deleteById(id);}
}
