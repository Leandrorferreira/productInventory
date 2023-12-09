package com.inventory.productInventory.service;

import com.inventory.productInventory.entity.Category;
import com.inventory.productInventory.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Category> search(Long id, String name, Integer type, String producName, Pageable pageable) {
        try {
            return categoryRepository.search(id, name, type, producName, pageable);
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
