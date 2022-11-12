package com.eCommerce.eCommerceLivraria.api;

import com.eCommerce.eCommerceLivraria.model.Endereco;
import com.eCommerce.eCommerceLivraria.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;


    @PostMapping
    public ResponseEntity save(@RequestBody Endereco endereco) {
        repository.save(endereco);

        return ResponseEntity.badRequest().body("Salvo com sucesso !");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Endereco endereco, @PathVariable Long id) {
        Endereco e = repository.save(endereco);
        return ResponseEntity.ok(e);
    }


}
