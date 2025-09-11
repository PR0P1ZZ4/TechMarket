package br.com.Ecommerce.api.controller;

import br.com.Ecommerce.api.model.ItemDoPedido;
import br.com.Ecommerce.api.service.ItemDoPedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/itemdopedido")
@Tag(name = "Item Do Pedido", description = "Operações relacionadas aos itens de cada pedido")
public class ItemDoPedidoController {
    private final ItemDoPedidoService itemDoPedidoService;

    public ItemDoPedidoController(ItemDoPedidoService itemDoPedidoService) {
        this.itemDoPedidoService = itemDoPedidoService;
    }

@GetMapping
public ResponseEntity<List<ItemDoPedido>> listarItemDoPedido(){
        List<ItemDoPedido> itemDoPedidos = itemDoPedidoService.ListarTodos();
    return ResponseEntity.ok(itemDoPedidos);
}

@PostMapping
    public ResponseEntity<ItemDoPedido> cadastrarItemDoPedido(@RequestBody ItemDoPedido itemDoPedido){
        itemDoPedidoService.cadastrarItemDoPedido(itemDoPedido);
        return ResponseEntity.ok(itemDoPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDoPedido> buscarItemDoPedido(@PathVariable Integer id){
        ItemDoPedido itemDoPedido = itemDoPedidoService.buscarItemDoPedidoPorId(id);
        if(itemDoPedido == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(itemDoPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerItemDoPedido(@PathVariable Integer id){
        ItemDoPedido itemDoPedido = itemDoPedidoService.deletarItemDoPedidoPorId(id);
        if (itemDoPedido == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")

    public ResponseEntity<?> atualizarItemDoPedidoPorId(@PathVariable int id, @RequestBody ItemDoPedido itemDoPedidoNovo){

        ItemDoPedido itemDoPedidoantigo = itemDoPedidoService.atualizarItemDoPedido(id, itemDoPedidoNovo);
        if(itemDoPedidoantigo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(itemDoPedidoantigo);

    }
}
