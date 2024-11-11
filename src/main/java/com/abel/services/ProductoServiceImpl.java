package com.abel.services;

import com.abel.model.Cliente;
import com.abel.model.Producto;
import com.abel.repository.ClienteRepository;
import com.abel.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl  extends GenericServiceImpl<Producto, Long> implements GenericService<Producto, Long>{

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public CrudRepository<Producto, Long> getDao() {
        return productoRepository;
    }




    // Método para obtener el siguiente id disponible
    // Obtener el siguiente ID de producto
    public Long getSiguienteId() {
        return productoRepository.getNextId();
    }

}
