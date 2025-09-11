package br.com.Ecommerce.api.service;


import br.com.Ecommerce.api.model.Produto;
import br.com.Ecommerce.api.repository.ClienteRepository;
import br.com.Ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository repo) {
        this.produtoRepository = repo;
    }

    public List<Produto> ListarTodos() {
        return this.produtoRepository.findAll();

    }
public Produto cadastrarProduto (Produto pd) {
        return this.produtoRepository.save(pd);

}
public Produto buscarPorId(int id) {
        return this.produtoRepository.findById(id).orElse(null);
}

public Produto deletarProdutoPorId(int id) {
        Produto pd = buscarPorId(id);
    if (pd == null) {
        return null;
    }

    produtoRepository.delete(pd);
    return pd;
    }

    public Produto atualizarProduto (int id, Produto produtoNovo) {
        Produto produtoantigo = buscarPorId(id);
        if (produtoantigo == null) {
            return null;
        }

        produtoantigo.setNomeProduto(produtoNovo.getNomeProduto());
        produtoantigo.setPreco(produtoNovo.getPreco());
        produtoantigo.setDescricao(produtoNovo.getDescricao());
        produtoantigo.setImagemUrl(produtoNovo.getImagemUrl());
        produtoantigo.setEstoqueDisponivel(produtoNovo.getEstoqueDisponivel());
        return produtoRepository.save(produtoantigo);
    }
}

