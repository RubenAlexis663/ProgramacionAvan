package com.api.sexshop.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntity {
    private UUID id;
    private UUID id_cliente;
    private UUID id_producto;
    private int cantidad;
    private Double total;
}
