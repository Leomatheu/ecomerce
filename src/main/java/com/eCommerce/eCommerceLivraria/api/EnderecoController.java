package com.eCommerce.eCommerceLivraria.api;

import com.eCommerce.eCommerceLivraria.model.Cliente;
import com.eCommerce.eCommerceLivraria.model.Endereco;
import com.eCommerce.eCommerceLivraria.model.Produto;
import com.eCommerce.eCommerceLivraria.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;


    @PostMapping
    public ResponseEntity save(@RequestBody Endereco endereco) {
        repository.save(endereco);

        return ResponseEntity.ok().body("Salvo com sucesso !");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Endereco endereco, @PathVariable Long id) {
        Endereco e = repository.save(endereco);
        return ResponseEntity.ok(e);
    }

    @GetMapping
    public List<Endereco> getAllEndereco() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        Optional<Endereco> endereco =repository.findById(id);

        if (endereco.isPresent()) {
            return ResponseEntity.ok(endereco.get());
        }
        return ResponseEntity.badRequest().body("id not found");
    }


}
