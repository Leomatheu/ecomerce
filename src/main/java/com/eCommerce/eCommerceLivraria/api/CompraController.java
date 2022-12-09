package com.eCommerce.eCommerceLivraria.api;


import com.eCommerce.eCommerceLivraria.model.Compra;
import com.eCommerce.eCommerceLivraria.model.Endereco;
import com.eCommerce.eCommerceLivraria.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    CompraRepository repository;

    @PostMapping
    public ResponseEntity save(@RequestBody Compra compra) {

        compra.getItens().forEach(i -> i.setCompra(compra));
        repository.save(compra);
        System.out.println(compra);
        return ResponseEntity.ok().body("Salvo com sucesso !");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Compra compra, @PathVariable Long id) {
        Compra c = repository.save(compra);
        return ResponseEntity.ok(c);
    }

    @GetMapping
    public List<Compra> getAllCompra() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        Optional<Compra> compra =repository.findById(id);

        if (compra.isPresent()) {
            return ResponseEntity.ok(compra.get());
        }
        return ResponseEntity.badRequest().body("id not found");
    }



}
