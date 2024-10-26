package com.api.sexshop.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEntity {
    private UUID id;
    private String nombre;
    private String Categoria;
    private double precio;
    private int stock;
}
