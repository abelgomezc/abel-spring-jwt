package com.abel.repository;

import com.abel.model.Cliente;
import com.abel.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturaRepository  extends JpaRepository<Factura, Integer> {

    // Método personalizado para buscar por diferentes campos (id, username, fecha, total)
    @Query("SELECT f FROM Factura f WHERE " +
            "CAST(f.id AS string) LIKE %:query% OR " +
            "LOWER(f.user.username) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "CAST(f.total AS string) LIKE %:query% OR " +
            "CAST(f.fecha AS string) LIKE %:query%")
    List<Factura> findByQuery(@Param("query") String query);
}
