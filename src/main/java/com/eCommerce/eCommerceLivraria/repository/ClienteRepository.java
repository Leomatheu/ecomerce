package com.eCommerce.eCommerceLivraria.repository;

import com.eCommerce.eCommerceLivraria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente,  Long> {
}
