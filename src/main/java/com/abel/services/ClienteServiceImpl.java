package com.abel.services;

import com.abel.model.Cliente;
import com.abel.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Integer> implements GenericService<Cliente, Integer> {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public CrudRepository<Cliente, Integer> getDao() {
        return clienteRepository;
    }

}



