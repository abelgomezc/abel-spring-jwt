package com.abel.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Double precioUnitario;

    private int stock;

    // Relación inversa con DetalleFactura
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    @JsonManagedReference // Controla la serialización de la relación Producto -> Detalles
    private List<DetalleFactura> detalles;
}

