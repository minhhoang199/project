package com.tm.j10.service;

import com.tm.j10.domain.Category;
import com.tm.j10.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory() {
        return this.categoryRepository.findAllCategoryByIsEnableIsTrue();
    }

    public Optional<Category> getAllCategorySlug(String slug) {
        return this.categoryRepository.findBySlug(slug);
    }

}
