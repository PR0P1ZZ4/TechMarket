package br.com.Ecommerce.api.service;

import br.com.Ecommerce.api.model.Pagamento;
import br.com.Ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;


    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public List<Pagamento> ListarTodos() {
        return this.pagamentoRepository.findAll();

    }

    public Pagamento cadastrarPagamento (Pagamento pg) {
        return this.pagamentoRepository.save(pg);

    }



}
