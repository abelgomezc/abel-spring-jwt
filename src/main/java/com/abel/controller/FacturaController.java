package com.abel.controller;

import com.abel.model.Cliente;
import com.abel.model.Factura;
import com.abel.model.dto.FacturaDTO;
import com.abel.services.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/factura/")
public class FacturaController {

    @Autowired
    private FacturaServiceImpl facturaService;
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listarFacturas")
    public ResponseEntity<List<FacturaDTO>> listaFacturas() {
        return new ResponseEntity<>(facturaService.findAllFacturas(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/filtrar")
    public ResponseEntity<List<FacturaDTO>> filtrarFacturas(@RequestParam String query) {
        List<FacturaDTO> facturasFiltradas = facturaService.filtrarFacturas(query);
        return ResponseEntity.ok(facturasFiltradas);
    }

}
