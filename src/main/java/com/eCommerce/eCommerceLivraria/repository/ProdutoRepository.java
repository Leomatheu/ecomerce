package com.eCommerce.eCommerceLivraria.repository;

import com.eCommerce.eCommerceLivraria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
