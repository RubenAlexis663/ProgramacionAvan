package com.example.crud.service;

import com.example.crud.model.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private List<ProductEntity> products = new ArrayList<>();

    public ProductService() {
        // Inicializar con algunos productos de ejemplo
        products.add(new ProductEntity("Dildos", "juguete", 1000.00, 50, "sexshop"));
        products.add(new ProductEntity("Muñeca inflable", "juguete", 150.00, 30, "sexshop"));
        products.add(new ProductEntity("Polvo", "producto", 500.00, 15, "sexshop"));
        products.add(new ProductEntity("Esmalte", "producto", 1000.00, 50, "maquillaje"));
        products.add(new ProductEntity("Labial", "producto", 150.00, 30, "maquillaje"));
        products.add(new ProductEntity("Base", "producto", 500.00, 15, "maquillaje"));
    }

    // Métodos CRUD
    public List<ProductEntity> getAllProducts() {
        return products;
    }

    public Optional<ProductEntity> getProductById(UUID id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public ProductEntity addProduct(ProductEntity product) {
        product.setId(UUID.randomUUID());
        products.add(product);
        return product;
    }

    public Optional<ProductEntity> updateProduct(UUID id, ProductEntity updatedProduct) {
        Optional<ProductEntity> existingProduct = getProductById(id);
        existingProduct.ifPresent(product -> {
            product.setName(updatedProduct.getName());
            product.setCategory(updatedProduct.getCategory());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
        });
        return existingProduct;
    }

    public boolean deleteProduct(UUID id) {
        return products.removeIf(product -> product.getId().equals(id));
    }

    public Optional<ProductEntity> getProductByTienda(String tienda) {

        return products.stream().filter(product -> product.getTienda().equals(tienda)).findFirst();
    }
}
