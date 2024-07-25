package com.example.dao;

import com.example.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Create a new category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Get a category by its ID
    public Category getCategory(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            return category.get();
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    // Update an existing category
    public Category updateCategory(Long categoryId, Category category) {
        if (categoryRepository.existsById(categoryId)) {
            category.setCategoryId(categoryId);
            return categoryRepository.save(category);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    // Delete a category by its ID
    public void deleteCategory(Long categoryId) {
        if (categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
