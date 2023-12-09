package com.inventory.productInventory.service;

import com.inventory.productInventory.entity.Category;
import com.inventory.productInventory.entity.Product;
import com.inventory.productInventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;
    private final CategoryService categoryService;

    public List<Product> findAll() {
        List<Product> products = repository.findAll();

        return products;
    }

    public Product findById(Long id) {
        Optional<Product> product = repository.findById(id);

        if(product.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        return product.get();
    }

    public Product create(Product product) {
        Category category = categoryService.findByName(product.getCategory().getName()).orElseThrow(() -> new RuntimeException("Category name not found"));

        product.setCategory(category);

        return repository.save(product);
    }

    public Product update(Long id) {
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        repository.save(product.get());

        return product.get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
