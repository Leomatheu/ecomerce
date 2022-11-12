package com.eCommerce.eCommerceLivraria.api;

import com.eCommerce.eCommerceLivraria.model.Produto;
import com.eCommerce.eCommerceLivraria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping
    public List<Produto> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        Optional<Produto> produto =repository.findById(id);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }
        return ResponseEntity.badRequest().body("id not found");
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Produto produto) {
        repository.save(produto);

        return ResponseEntity.badRequest().body("Salvo com sucesso !");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Produto produto, @PathVariable Long id) {
        Produto p = repository.save(produto);
        return ResponseEntity.ok(p);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();

    }

}
