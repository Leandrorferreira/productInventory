package com.inventory.productInventory.controller;

import com.inventory.productInventory.dto.ProductDto;
import com.inventory.productInventory.entity.Category;
import com.inventory.productInventory.entity.Product;
import com.inventory.productInventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<Product> create(ProductDto dto) {
        Product product = Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .category(Category.builder()
                        .name(dto.getCategoryName())
                        .build())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
