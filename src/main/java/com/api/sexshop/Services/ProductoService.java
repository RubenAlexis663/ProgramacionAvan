package com.api.sexshop.Services;

import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.api.sexshop.Entitys.ProductoEntity;

@Service
public class ProductoService {
    private List<ProductoEntity> productos;

    public ProductoService() {
        productos = new ArrayList<>();
        productos.add(new ProductoEntity(UUID.randomUUID(), "Latigo", "Juguetes", 50000, 20));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Esposas de Piel", "Accesorios", 35000, 15));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Lubricante a base de Agua", "Lubricantes", 12000, 50));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Aceite de Masaje Aromático", "Cosméticos", 18000, 30));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Plug Anal", "Juguetes", 45000, 25));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Anillo Vibrador", "Juguetes", 30000, 40));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Gel Potenciador", "Cosméticos", 25000, 60));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Vibrador Clásico", "Juguetes", 55000, 20));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Látigo de Cuero", "Accesorios", 60000, 10));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Bolas Chinas", "Accesorios", 20000, 35));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Dildo Realista", "Juguetes", 70000, 15));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Disfraz de Enfermera", "Lencería", 40000, 25));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Plug de Cristal", "Juguetes", 65000, 10));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Lubricante con Sabor", "Lubricantes", 15000, 40));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Antifaz de Seda", "Accesorios", 12000, 50));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Lencería de Encaje", "Lencería", 45000, 30));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Arnés Ajustable", "Accesorios", 50000, 12));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Camisón Transparente", "Lencería", 35000, 18));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Gel Estimulante", "Cosméticos", 20000, 30));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Correa de Cuero", "Accesorios", 45000, 10));
        productos.add(new ProductoEntity(UUID.randomUUID(), "Lubricante Silicona", "Lubricantes", 17000, 25));
    }

    //(GET) {READ - ALL}
    public List<ProductoEntity> getAllProductos(){
        return productos;
    }

    //(GET) {READ - ID}
    public Optional<ProductoEntity> getProductoById(UUID id){
        return productos.stream().filter(producto -> producto.getId().equals(id)).findFirst();
    }

    //(POST) {CREATE}
    public String createProducto(ProductoEntity producto){
        if(!(producto.getNombre().isEmpty()) && !(producto.getCategoria().isEmpty()) && (producto.getPrecio()!=0)){
            producto.setId(UUID.randomUUID());
            productos.add(producto);
            return "Se agrego correctamente el producto "+producto.getNombre();
        }
        return "No se pudo agregar el producto, llena completamente los campos.";
    }

    //(PUT){UPDATE}
    public String updateProductoById(UUID id, ProductoEntity producto) {
        Optional<ProductoEntity> productoList = getProductoById(id);
        if(productoList.isPresent() && !(producto.getNombre().isEmpty()) && !(producto.getCategoria().isEmpty()) && (producto.getPrecio()!=0)){
            productoList.get().setNombre(producto.getNombre());
            productoList.get().setCategoria(producto.getCategoria());
            productoList.get().setStock(producto.getStock());
            productoList.get().setPrecio(producto.getPrecio());
            return "Se actualizo correctamente el producto "+producto.getNombre();
        }
        return "No se encontro el producto o no llenaste correctamente los campos.";
    }

    //(DELETE){DELETE}
    public String deleteProductoById(UUID id) {
        if(getProductoById(id).isPresent()){
            productos.removeIf(producto -> producto.getId().equals(id));
            return "Se eliminó el empleado con el id "+id;
        }
        return "No se encontró el empleado.";
    }
}
