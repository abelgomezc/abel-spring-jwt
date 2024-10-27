package com.abel.repository;

import com.abel.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Abel Gomez
 */
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

//    @Query(value = "Select * from cliente u where u.nombre = :nombre", nativeQuery = true)
//    public Cliente buscarCliente(String nombre);
}




