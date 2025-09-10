package br.com.Ecommerce.api.controller;

import br.com.Ecommerce.api.model.ItemDoPedido;
import br.com.Ecommerce.api.service.ItemDoPedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/itemdopedido")
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
}
