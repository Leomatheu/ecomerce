package com.eCommerce.eCommerceLivraria.api;

import com.eCommerce.eCommerceLivraria.model.Cliente;
import com.eCommerce.eCommerceLivraria.model.Produto;
import com.eCommerce.eCommerceLivraria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;


    @GetMapping
    public List<Cliente> getAllClientes() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        Optional<Cliente> cliente = repository.findById(id);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.badRequest().body("id not found");
    }


    @PostMapping
    public ResponseEntity save(@RequestBody Cliente cliente) {
        repository.save(cliente);

        return ResponseEntity.badRequest().body("Salvo com sucesso !");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente c = repository.save(cliente);
        return ResponseEntity.ok(c);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    @RequestMapping("/cliente-email/{email}")
    public List<Cliente> findEmailSenha(@PathVariable("email") String emailCliente) {
        return repository.findEmailSenha(emailCliente);
    }

}
