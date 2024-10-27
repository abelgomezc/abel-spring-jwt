package com.abel.model.dto;

import lombok.Data;

@Data
public class DetalleFacturaDTO {
    private Long id;
    private String nombre_producto;
    private Double precio_producto;
    private Integer cantidad;
    private Double precio;
}