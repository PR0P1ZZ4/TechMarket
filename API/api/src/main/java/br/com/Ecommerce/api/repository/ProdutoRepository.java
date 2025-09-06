package br.com.Ecommerce.api.repository;

import br.com.Ecommerce.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
