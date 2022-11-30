package com.eCommerce.eCommerceLivraria.repository;

import com.eCommerce.eCommerceLivraria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("select p from Produto p " +
            "where p.categoria.id_categoria = :categoriaId")


    public List<Produto> findSelectPorMarca(Long categoriaId);


}
