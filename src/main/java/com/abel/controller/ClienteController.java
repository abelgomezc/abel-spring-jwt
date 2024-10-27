package com.abel.controller;

import com.abel.model.Cliente;
import com.abel.services.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente/")
public class ClienteController {


    @Autowired
    ClienteServiceImpl clienteService;
    @PreAuthorize("hasRole('ADMIN','')")
    @GetMapping("/listarClientes")
    public ResponseEntity<List<Cliente>> listaClientes() {
        return new ResponseEntity<>(clienteService.findByAll(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevoCliente")
    public ResponseEntity<Cliente> crearUsuario(@RequestBody Cliente u) {
        return new ResponseEntity<>(clienteService.save(u), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/EdiarCliente/{id}")
    public ResponseEntity<Cliente> actualizarUsuario(@PathVariable Integer id, @RequestBody Cliente c) {
        Cliente cliente = clienteService.findById(id);
        if (cliente != null) {
            try {
                cliente.setNombre_cliente(c.getNombre_cliente());
                cliente.setEstado(c.isEstado());
                cliente.setEmail(c.getEmail());
                return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminarCliente/{id}")
    public ResponseEntity<Cliente> elimiarUsuario(@PathVariable Integer id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
