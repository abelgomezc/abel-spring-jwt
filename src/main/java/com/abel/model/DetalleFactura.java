package com.abel.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String producto;
    private Integer cantidad;
//    private Double precio;

    @JoinColumn(name = "factura_id")
    @ManyToOne
    @JsonBackReference // Evita la recursión de vuelta hacia Factura
    private Factura factura;

    // Relación con Producto
    @JoinColumn(name = "producto_id")
    @ManyToOne
    @JsonIgnoreProperties({"detalles"}) // Evita la recursión hacia DetalleFactura
    private Producto producto;

}
