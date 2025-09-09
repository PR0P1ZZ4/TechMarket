package br.com.Ecommerce.api.controller;

import br.com.Ecommerce.api.model.Pedido;
import br.com.Ecommerce.api.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@PostMapping
public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
        pedidoService.cadastrarPedido(pedido);
        return ResponseEntity.ok(pedido);

}
}
