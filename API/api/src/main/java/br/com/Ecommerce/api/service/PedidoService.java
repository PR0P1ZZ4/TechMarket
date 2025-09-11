package br.com.Ecommerce.api.service;


import br.com.Ecommerce.api.model.Pedido;
import br.com.Ecommerce.api.model.Produto;
import br.com.Ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;


    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    public List<Pedido> ListarTodos() {
        return this.pedidoRepository.findAll();

    }

    public Pedido cadastrarPedido(Pedido pd) {
        return this.pedidoRepository.save(pd);
    }

    public Pedido buscarPorId(int id) {
        return this.pedidoRepository.findById(id).orElse(null);
    }

    public Pedido deletarPorId(int id) {
        Pedido pedido = buscarPorId(id);
        if (pedido != null) {
            return null;
        }
        this.pedidoRepository.deleteById(id);
        return pedido;
    }
}
