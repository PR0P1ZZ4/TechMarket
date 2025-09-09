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

    public List<ItemDoPedido> findAll() {
        return this.itemDoPedidoRepository.findAll();

    }


}
