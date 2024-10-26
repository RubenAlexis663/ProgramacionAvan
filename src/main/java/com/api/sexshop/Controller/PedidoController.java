package com.api.sexshop.Controller;

import com.api.sexshop.Entitys.PedidoEntity;
import com.api.sexshop.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/sexshop/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<PedidoEntity> getAllPedidos() {
        return pedidoService.getPedidos();
    }

    @GetMapping("/{id}")
    public Optional<PedidoEntity> getPedido(@PathVariable UUID id) {
        return pedidoService.getPedidoById(id);
    }

    @PostMapping
    public String createPedido(@RequestBody PedidoEntity pedido) {
        return pedidoService.createPedido(pedido);
    }

    @PutMapping("/{id}")
    public String updatePedidoById(@PathVariable UUID id, @RequestBody PedidoEntity pedido) {
        return pedidoService.updatePedido(id, pedido);
    }

    @DeleteMapping("/{id}")
    public String deletePedido(@PathVariable UUID id) {
        return pedidoService.deletePedido(id);
    }
}
