package com.abel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String urlimagen;

    private int stock;

    private Boolean estado;

    // Relación inversa con DetalleFactura
//    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
//    @JsonManagedReference // Controla la serialización de la relación Producto -> Detalles
//    private List<DetalleFactura> detalles;

    // Avoid serializing the 'detalles' field when listing products
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    @JsonIgnore // Prevents the serialization of DetalleFactura list
    private List<DetalleFactura> detalles;
}

