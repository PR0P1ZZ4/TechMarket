package br.com.Ecommerce.api.controller;

import br.com.Ecommerce.api.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.Ecommerce.api.service.ClienteService;

import java.util.List;
@RestController
@RequestMapping("/api/clientes")

public class ClienteController {
    // controller - service
    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // listar todos
    @GetMapping
    public ResponseEntity<List<Cliente>> ListarClientes(){
        //1. pegar a lista dos clientes
        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);

    }



}
