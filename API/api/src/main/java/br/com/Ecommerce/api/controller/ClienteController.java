package br.com.Ecommerce.api.controller;

import br.com.Ecommerce.api.model.Cliente;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.Ecommerce.api.service.ClienteService;

import java.util.List;
@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "Operações relacionadas ao cadastro de clientes")
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

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente (@RequestBody Cliente cliente){
// tentar cadastrar cliente
    clienteService.cadastrarCliente(cliente);

// codigo 200 - ok
    return ResponseEntity.ok(cliente);

// codigo 201 - created
// return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
    // buscar cliente por id
    // GET, POST PUT, DELETE
    @GetMapping("/{id}")
    // Path variable recebe um valor no link
    // Request body recebe dados pelo corpo
    public ResponseEntity<?> buscarClientePorId(@PathVariable int id){
    // 1. procurar e guardar o cliente
    Cliente cl = clienteService.buscarPorId(id);
    // 2. se eu nao encontrar retorno erro
    if (cl == null){
        // Mais simples
        // return ResponseEntity.notFound().build();
        // mais detalhes e com possibilidade de colocar a mensagem que quiser
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente" + id + " não encontrado!");
    }
    // 3. se encontrar retorno o cliente
        return ResponseEntity.ok(cl);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarClientePorId(@RequestParam int id){
        // 1. verifico se o cliente existe
        Cliente cl = clienteService.deletarCliente(id);
        // 2. se nao existir retorno erro
        if (cl == null){
            return ResponseEntity.notFound().build();
        }
        // 3. se existir excluo
        return ResponseEntity.ok(cl);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarClientePorId(@PathVariable int id, @RequestBody Cliente clienteNovo){
        // 1. Tento atualizar o cliente
        Cliente cl = clienteService.atualizarCliente(id, clienteNovo);
        // 2. se nao achar o cliente retorno null
        if  (cl == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        // 3. se achar atualizar
        return ResponseEntity.ok(cl);
    }

}
