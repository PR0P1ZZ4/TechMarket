package br.com.Ecommerce.api.repository;

import br.com.Ecommerce.api.model.ItemDoPedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDoPedidoRepository extends CrudRepository<ItemDoPedido,Integer> {

}
