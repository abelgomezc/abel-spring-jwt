package com.abel.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FacturaDTO {
    private Long id;
    private Date fecha;
    private Double total;
    private Long userId; // Solo el id del usuario
    private String username;
    private List<DetalleFacturaDTO> detalles; // Lista de detalles de la factura
}