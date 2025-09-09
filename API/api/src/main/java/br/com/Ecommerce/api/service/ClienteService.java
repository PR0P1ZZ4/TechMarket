package br.com.Ecommerce.api.service;

import br.com.Ecommerce.api.model.Cliente;
import org.springframework.stereotype.Service;
import br.com.Ecommerce.api.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    // injeção de dependencia
    // falar que service depende de alguem
    // final - constante
    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository repo) {
        this.clienteRepository = repo;





    }

    // listar todos os clientes
    public List<Cliente> listarTodos() {
        return this.clienteRepository.findAll();
    }


    public Cliente cadastrarCliente (Cliente cl) {
        return clienteRepository.save(cl);

    }



}