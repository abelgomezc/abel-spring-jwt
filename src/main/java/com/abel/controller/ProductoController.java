package com.abel.controller;


import com.abel.model.Cliente;
import com.abel.model.Producto;
import com.abel.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto/")
public class ProductoController {


    @Autowired
    ProductoServiceImpl productoService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listarProductos")
    public ResponseEntity<List<Producto>> listaProductos() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevoProducto")
    public ResponseEntity<Producto> crear(@RequestBody Producto u) {
        return new ResponseEntity<>(productoService.save(u), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/EdiarProducto/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto c) {
        Producto producto = productoService.findById(id);
        if (producto != null) {
            try {
                producto.setNombre(c.getNombre());
                producto.setEstado(c.getEstado());
                producto.setDescripcion(c.getDescripcion());
                producto.setStock(c.getStock());
                producto.setUrlimagen(c.getUrlimagen());
                producto.setPrecioUnitario(c.getPrecioUnitario());
                return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<Producto> elimiar(@PathVariable Long id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/siguienteIDProducto")
    public ResponseEntity<Long> siguienteID() {
        Long siguienteId = productoService.getSiguienteId();
        return new ResponseEntity<>(siguienteId, HttpStatus.OK);
    }
}
