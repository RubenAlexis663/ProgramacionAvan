package com.api.sexshop.Services;

import com.api.sexshop.Entitys.PedidoEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    private List<PedidoEntity> pedidos;
    public PedidoService() {
        pedidos = new ArrayList<>();
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("37c7ecfb-20b4-4b45-aa53-0a941c584e27"), UUID.fromString("4f50c9e8-bfac-44cf-bd73-0f0d28f74ed9"), 2, 70000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("f9b34cc2-645f-47c7-95f4-94f5a68deadc"), UUID.fromString("a3b9e9d7-e8f0-40ae-9de3-1cbb33b82ccf"), 1, 30000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("15ae22b7-02c3-4671-8a56-83692a65c499"), UUID.fromString("6cf91d08-9f71-4d0f-994a-c2e8b9e7f1f1"), 3, 54000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("b2e27f5f-4781-4a47-b6be-f77a18f88c39"), UUID.fromString("b8a03e54-cd2e-437f-8099-c1e81fa1e6e2"), 1, 60000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("5f17c5e4-2f8b-4db5-87f1-6b11e2291af3"), UUID.fromString("d9c219a5-8f90-469e-bfb2-3f7c34d8c715"), 2, 140000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("d7ff62ad-2e1c-4eb4-9e3f-3a4c76c7e0c8"), UUID.fromString("a6d4c8d3-79c6-4ae4-98d8-99e0b10af2a5"), 1, 55000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("89a64c5d-0fd8-4e67-8bb5-c1589d0a1f33"), UUID.fromString("2c25db4f-9e10-4828-8bd5-9d79e1ed8b4e"), 4, 180000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("6a0d6b6b-98a3-43ab-91d7-2fd9347c4fdd"), UUID.fromString("2cfa9d93-3c82-4b7e-8107-2c2904565ec9"), 1, 65000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("1b3c3a95-315f-453b-90f7-0f27d15a9d25"), UUID.fromString("add9f02f-0325-4a1e-8b2a-709cdfa4a251"), 3, 135000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("2a584737-5b85-4201-b5ef-54d83154e96f"), UUID.fromString("bc9b8935-d037-4887-8432-847e5fa2f42c"), 2, 50000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("edfe84f7-c73b-4d89-94a2-3a4e8f7b9a90"), UUID.fromString("3cf9f07d-dc1e-44a3-9674-0d5174a1a0de"), 5, 75000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("dc5c3ff6-08e8-403f-8c7f-e2f2c47ef2d2"), UUID.fromString("4d2a91db-9b8c-4909-9f68-3d44dbedaf9d"), 1, 20000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("74c893b1-0157-4c62-8f2e-2af2c31706f1"), UUID.fromString("98d1d02a-203a-4fe4-bc38-2d08c4b48f6c"), 2, 70000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("cfaf33f3-4147-4cfb-b8c2-e57b9a6f4071"), UUID.fromString("9f5e4f92-b734-4c2e-ae2f-c5a5e3f95d5f"), 1, 45000.0));
        pedidos.add(new PedidoEntity(UUID.randomUUID(), UUID.fromString("aefb7e7a-47e4-4fe1-94e8-9b83d787dc8b"), UUID.fromString("af293d7b-f3d5-4e6a-abc5-2e09b0a8d252"), 3, 120000.0));
    }

    //(GET){READ - ALL}
    public List<PedidoEntity> getPedidos() {
        return pedidos;
    }

    //(GET){READ - ID}
    public Optional<PedidoEntity> getPedidoById(UUID id) {
        return pedidos.stream().filter(pedido -> pedido.getId().equals(id)).findFirst();
    }

    //(POST){CREATE}
    public String createPedido(PedidoEntity pedido) {
        if(!(pedido.getId_cliente().equals("")) && !(pedido.getId_producto().equals("")) && !(pedido.getCantidad()==0)){
            pedido.setId(UUID.randomUUID());
            pedidos.add(pedido);
            return "Se agrego correctamente el pedido "+pedido.getId_cliente();
        }
        return "No se pudo agregar el pedido, llena completamente los campos.";
    }

    //(PUT){UPDATE}
    public String updatePedido(UUID id, PedidoEntity pedido) {
        Optional<PedidoEntity> pedidoList = getPedidoById(id);
        if(pedidoList.isPresent() && !(pedido.getId_cliente().equals("")) && !(pedido.getId_producto().equals("")) && !(pedido.getCantidad()==0)){
            pedidoList.get().setId_cliente(pedido.getId_cliente());
            pedidoList.get().setId_producto(pedido.getId_producto());
            pedidoList.get().setCantidad(pedido.getCantidad());
            pedidoList.get().setTotal(pedido.getTotal());
            return "Se actualizo correctamente el pedido "+pedido.getId_cliente();
        }
        return "No se encontro el pedido o no llenaste correctamente los campos.";
    }

    //(DELETE){DELETE}
    public String deletePedido(UUID id) {
        if(getPedidoById(id).isPresent()){
            pedidos.removeIf(pedido -> pedido.getId().equals(id));
            return "Se eliminó el pedido con el id "+id;
        }
        return "No se encontró el pedido.";
    }
}
