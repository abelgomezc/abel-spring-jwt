package com.abel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class  Cliente  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id_cliente;
    private String nombre_cliente;
    private boolean estado;
    private  String email;

//    @OneToMany(mappedBy = "cliente")
//    @JsonIgnore // Esto evita que las facturas se incluyan al serializar Cliente
//    private List<Factura> facturas;

}
