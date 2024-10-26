package com.api.sexshop.Controller;

import com.api.sexshop.Entitys.ProductoEntity;
import com.api.sexshop.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/sexshop/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoEntity> getAllEmpleados() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Optional<ProductoEntity> getProductoById(@PathVariable UUID id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public String createProducto(@RequestBody ProductoEntity producto) {
        return productoService.createProducto(producto);
    }

    @PutMapping("/{id}")
    public String updateProducto(@PathVariable UUID id, @RequestBody ProductoEntity producto) {
        return productoService.updateProductoById(id, producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable UUID id) {
        return productoService.deleteProductoById(id);
    }

}
