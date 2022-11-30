package com.eCommerce.eCommerceLivraria.api;

import com.eCommerce.eCommerceLivraria.model.Itens;
import com.eCommerce.eCommerceLivraria.repository.ItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/itens")
public class ItensController implements Serializable {

    @Autowired
    ItensRepository repository;

    @GetMapping
    public List<Itens> getAllItens() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        Optional<Itens> itens =repository.findById(id);

        if (itens.isPresent()) {
            return ResponseEntity.ok(itens.get());
        }
        return ResponseEntity.badRequest().body("id not found");
    }


    @PostMapping
    public ResponseEntity save(@RequestBody Itens itens) {
        repository.save(itens);

        return ResponseEntity.badRequest().body("Salvo com sucesso !");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Itens itens, @PathVariable Long id) {
        Itens i = repository.save(itens);
        return ResponseEntity.ok(i);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();

    }
}
