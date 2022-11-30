package com.eCommerce.eCommerceLivraria.repository;

import com.eCommerce.eCommerceLivraria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository  extends JpaRepository<Cliente,  Long> {

    @Query("select c from Cliente c " +
            "where c.email = :emailCliente")

    public List<Cliente> findEmailSenha(String  emailCliente);
}
