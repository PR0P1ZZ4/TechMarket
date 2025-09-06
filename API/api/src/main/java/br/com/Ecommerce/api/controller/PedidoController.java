package br.com.Ecommerce.api.controller;

import br.com.Ecommerce.api.model.Pedido;
import br.com.Ecommerce.api.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos(){

        List<Pedido> pedidos = pedidoService.ListarTodos();
        return ResponseEntity.ok(pedidos);

    }

}
