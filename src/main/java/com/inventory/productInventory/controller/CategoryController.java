package com.inventory.productInventory.controller;

import com.inventory.productInventory.dto.CategoryDto;
import com.inventory.productInventory.entity.Category;
import com.inventory.productInventory.entity.Product;
import com.inventory.productInventory.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Category> create(CategoryDto dto) {
        Category category = Category.builder()
                .name(dto.getName())
                .type(dto.getType())
                .build();
        return ResponseEntity.ok().body(categoryService.save(category));
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> findByParams(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer type,
            @RequestParam(required = false) String productName) {

        return ResponseEntity.ok(categoryService.search(id, name, type, productName));
    }

}
