package br.com.Ecommerce.api.controller;

import br.com.Ecommerce.api.model.Pagamento;
import br.com.Ecommerce.api.service.ClienteService;
import br.com.Ecommerce.api.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

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


}
