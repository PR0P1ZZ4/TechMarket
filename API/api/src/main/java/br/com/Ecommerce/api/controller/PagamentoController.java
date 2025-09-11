package br.com.Ecommerce.api.controller;

import br.com.Ecommerce.api.model.Pagamento;
import br.com.Ecommerce.api.service.ClienteService;
import br.com.Ecommerce.api.service.PagamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
@Tag(name = "Pagamentos", description = "Operações relacionadas aos pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

@GetMapping
    public ResponseEntity<List<Pagamento>> listarPagamentos(){
        List<Pagamento> pagamento = pagamentoService.ListarTodos();
        return ResponseEntity.ok(pagamento);


   }
@PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody Pagamento pagamento){
        pagamentoService.cadastrarPagamento(pagamento);
        return ResponseEntity.ok(pagamento);

}

@GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPagamento(@PathVariable int id){
        Pagamento pg = pagamentoService.buscarPagamentoPorID(id);
        if(pg==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pg);
}

@DeleteMapping("/{id}")
    public ResponseEntity<Pagamento> deletarPagamento(@PathVariable int id){
        Pagamento pg = pagamentoService.deletarPagamento(id);
        if(pg==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pg);
}
}
