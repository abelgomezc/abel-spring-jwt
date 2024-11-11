package com.abel.repository;

import com.abel.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository  extends JpaRepository<Producto, Long> {


    @Query("SELECT COALESCE(MAX(p.id), 0) + 1 FROM Producto p")
    Long getNextId();
}


