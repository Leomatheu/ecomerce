package com.eCommerce.eCommerceLivraria.api;


import com.eCommerce.eCommerceLivraria.model.Categoria;
import com.eCommerce.eCommerceLivraria.model.Cliente;
import com.eCommerce.eCommerceLivraria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository repository;

    @GetMapping
    public List<Categoria> getAllCor() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        Optional<Categoria> categoria = repository.findById(id);

        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        }
        return ResponseEntity.badRequest().body("id not found");
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Categoria categoria) {
        repository.save(categoria);

        return ResponseEntity.badRequest().body("Salvo com sucesso !");
    }

}
