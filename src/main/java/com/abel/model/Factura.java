package com.abel.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private Double total;

    //    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @JsonManagedReference // Evita la recursión hacia el Cliente desde Factura
//    private User user ;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"username", "email", "password", "roles", "facturas"}) // Ignorar todo excepto 'id'
    private User user;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    @JsonManagedReference // Controla la serialización de la relación Factura -> Detalles
    private List<DetalleFactura> detalles;


}
