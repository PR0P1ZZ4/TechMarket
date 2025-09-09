package br.com.Ecommerce.api.repository;

import br.com.Ecommerce.api.model.ItemDoPedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDoPedidoRepository extends CrudRepository<ItemDoPedido,Integer> {
}
