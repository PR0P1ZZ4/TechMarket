package br.com.Ecommerce.api.controller;


import br.com.Ecommerce.api.model.Cliente;
import br.com.Ecommerce.api.model.Produto;
import br.com.Ecommerce.api.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")

public class ProdutoController {
    private final ProdutoService produtoService;


    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping
    public ResponseEntity<List<Produto>> ListarProdutos() {

        List<Produto> produtos = produtoService.ListarTodos();

        return ResponseEntity.ok(produtos);
    }
@PostMapping
    public ResponseEntity<Produto> CadastrarProduto(@RequestBody Produto pd){
        produtoService.cadastrarProduto(pd);
        return ResponseEntity.ok(pd);


}
@GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable int id){
        Produto pd = produtoService.buscarPorId(id);
        if(pd == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pd);
}

}
