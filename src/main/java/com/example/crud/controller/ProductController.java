package com.example.crud.controller;

import com.example.crud.model.ProductEntity;
import com.example.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<ProductEntity> getProductById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Optional<ProductEntity> updateProduct(@PathVariable UUID id, @RequestBody ProductEntity product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable UUID id) {
        return productService.deleteProduct(id);
    }
}
