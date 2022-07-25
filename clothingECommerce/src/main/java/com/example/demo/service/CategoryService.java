package com.example.demo.service;

import com.example.demo.domain.Category;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CategoryService{
    List<Category> findAll(Sort sort);

    <S extends Category> S save(S entity);

    Optional<Category> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    List<Category> findAll();

    void deleteById(Long aLong);
}
