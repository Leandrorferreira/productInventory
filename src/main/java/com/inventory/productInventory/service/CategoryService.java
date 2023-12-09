package com.inventory.productInventory.service;

import com.inventory.productInventory.entity.Category;
import com.inventory.productInventory.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<Category> search(Long id, String name, Integer type, String producName) {
        try {
            var category = categoryRepository.search(id, name, type, producName);
            return category;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
