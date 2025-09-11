package br.com.Ecommerce.api.controller;

import br.com.Ecommerce.api.model.Pedido;
import br.com.Ecommerce.api.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos", description = "Operações relacionadas aos pedidos dos clientes")
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

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable int id){
        Pedido pedido = pedidoService.buscarPorId(id);
        if (pedido != null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido);
    }
@DeleteMapping("/{id}")
    public ResponseEntity<Pedido> deletarPedidoPorId(@PathVariable int id){
        Pedido pedido = pedidoService.deletarPorId(id);
        if (pedido == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPedidoPorId(@PathVariable int id, @RequestBody Pedido pedidonovo) {

        Pedido pedidoantigo = pedidoService.atualizarPedido(id,pedidonovo);
        if (pedidoantigo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(pedidoantigo);
    }
}
