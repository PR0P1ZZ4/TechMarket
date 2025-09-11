package br.com.Ecommerce.api.service;

import br.com.Ecommerce.api.model.ItemDoPedido;
import br.com.Ecommerce.api.repository.ItemDoPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDoPedidoService {
    private final ItemDoPedidoRepository itemDoPedidoRepository;


    public ItemDoPedidoService(ItemDoPedidoRepository itemDoPedidoRepository) {
        this.itemDoPedidoRepository = itemDoPedidoRepository;
    }

    public List<ItemDoPedido> ListarTodos() {
        return (List<ItemDoPedido>) this.itemDoPedidoRepository.findAll();

    }
    public ItemDoPedido cadastrarItemDoPedido (ItemDoPedido pd) {
        return this.itemDoPedidoRepository.save(pd);
    }

    public ItemDoPedido buscarItemDoPedidoPorId(int id) {
        return this.itemDoPedidoRepository.findById(id).orElse(null);
    }

    public ItemDoPedido deletarItemDoPedidoPorId(int id) {
        ItemDoPedido itemDoPedido = buscarItemDoPedidoPorId(id);
        if (itemDoPedido == null) {
            return null;
        }
        itemDoPedidoRepository.delete(itemDoPedido);
        return itemDoPedido;
    }

}
