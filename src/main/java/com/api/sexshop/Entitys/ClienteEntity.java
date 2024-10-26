package com.api.sexshop.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {
    private UUID id;
    private String nombre;
    private String apellido;
    private int telefono;
    private String correo;
    private String direccion;
}
